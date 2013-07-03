package org.stepper.control;

import java.util.HashMap;
import java.util.List;

import org.stepper.exception.AppSequenceException;
import org.stepper.exception.ComponentExecutionException;
import org.stepper.interfaces.ErrorHandler;
import org.stepper.interfaces.Task;
import org.stepper.interfaces.TransactionalTask;

/**
 * The Class TransactionalAppSequence.
 *  This class is responsible providing transcation behaviour of the sequence.
 *  IF one of the task in the sequence fails the rollback sequence will initiate and rollback funtion will be called.
 *  Implementation of the rollback is developer dependent.
 *  
 * Author: Abhishek kapoor
 * 21 Jun, 2013
 */
public class TransactionalSequence extends AbstractTransactionalTask {
	
	/** The Constant NAME. */
	private static final String NAME = "TransactionalSequenceTasks";

	/** The sequence. */
	List sequence;
	
	/** The name. */
	private String name;

	
	
	/**
	 * Instantiates a new transactional app sequence.
	 *
	 * @param sequence the sequence
	 */
	public TransactionalSequence(List sequence) {
		super();

		this.sequence = sequence;
		// logger.debug("Application sequence initialised");
	}


	/**
	 * Start.
	 *
	 * @param valueStack the value stack
	 * @throws AppSequenceException the app sequence exception
	 */
	protected void start(HashMap valueStack) throws AppSequenceException {
		Task tsk = null;
		TransactionalTask tTsk = null;
		
		
		int i ;
		for (i= 0; i <= sequence.size() - 1; i++) {
			if(!(sequence.get(1) instanceof TransactionalTask)) throw new AppSequenceException("Found Non-Transactional task in transcational sequence");
			Object comp = sequence.get(i);
			try {
					tTsk = (TransactionalTask) comp;
					tTsk.execute(valueStack);
				} catch (Exception e) {
					e.printStackTrace();
					try {
						startRollBackSequence(i, valueStack);
					} catch (Exception e1) {
						e1.printStackTrace();
						throw new AppSequenceException("->"+"Error in rollback " + "[Task:" + tTsk.getName()+ "]", e);
						
					}
//					e.printStackTrace();
					throw new AppSequenceException("->[Task:" + tTsk.getName()+ "]", e);
					
					}
				}
		}
	

	/**
	 * Start roll back sequence.
	 *
	 * @param i the i
	 * @param valueStack the value stack
	 * @throws Exception 
	 */
	private void startRollBackSequence(int i, HashMap valueStack) throws Exception {
		while (i >= 0) {
			TransactionalTask comp = (TransactionalTask) sequence.get(i);
			System.out.println("RollBack: "+ comp.getName());
			comp.rollBack(valueStack);
			i--;
		}
	}

	/**
	 * Gets the sequence.
	 *
	 * @return the sequence
	 */
	public List getSequence() {
		return sequence;
	}

	/**
	 * Sets the sequence.
	 *
	 * @param sequence the new sequence
	 */
	public void setSequence(List sequence) {
		this.sequence = sequence;
	}

	/* (non-Javadoc)
	 * @see org.stepper.interfaces.TransactionalTask#getName()
	 */
	public String getName(){
		return this.NAME;
	}


	/* (non-Javadoc)
	 * @see org.stepper.interfaces.TransactionalTask#execute(java.util.HashMap)
	 */
	public  boolean execute(HashMap ValueStack)
		throws ComponentExecutionException{
		boolean success = false;
		try {
			start(ValueStack);
			success = true;
		} catch (AppSequenceException e) {
			e.printStackTrace();
			success = false;
			throw new ComponentExecutionException(e);
		}
		return success;
	}

	/* (non-Javadoc)
	 * @see org.stepper.interfaces.TransactionalTask#rollBack(java.util.HashMap)
	 */
	public boolean rollBack(HashMap valueStack) {
		return true;
	}

}

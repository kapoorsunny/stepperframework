package org.stepper.control;

import java.util.HashMap;
import java.util.List;

import org.stepper.exception.AppSequenceException;
import org.stepper.exception.ComponentExecutionException;
import org.stepper.interfaces.Task;
import org.stepper.interfaces.TransactionalTask;

// TODO: Auto-generated Javadoc
/**
 * The Class AppSequence.
 * This class calls the module defined into the configuration into sequential manner
 *  
 * Author: Abhishek kapoor
 */
public class Sequence extends AbstractTask {
	
	/** The Constant NAME. */
	private static final String NAME = "SequenceTasks";

	/** The sequence. */
	private List sequence;

	// list of components name to Hashmap

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

	/**
	 * Start.
	 *
	 * @param valueStack the value stack
	 * @throws AppSequenceException the app sequence exception
	 */
	private void start(HashMap valueStack) throws AppSequenceException {
		Task tsk = null;
				
//			System.out.println("size "+ sequence.size());
		for (int i = 0; i <= sequence.size() - 1; i++) {
			Object comp = sequence.get(i);
			if(!(sequence.get(i) instanceof Task)) throw new AppSequenceException("Found non Task component");
			if (comp instanceof Task) {
				try {
					tsk = (Task) comp;
					tsk.execute(valueStack);
				} catch (Exception e) {
					e.printStackTrace();
					if (tsk.getContinueOnError()) {
						tsk.getErrorHandler().handle(valueStack);

					} else {
						throw new AppSequenceException("[Task:" + tsk.getName()	+ "]" + e.getMessage(), e);
					}
				}
			} 
		}
		}
		
	

	/**
	 * Execute non transaction task.
	 */
	private void executeNonTransactionTask() {

	}

	/**
	 * Execute transaction task.
	 */
	private void executeTransactionTask() {

	}

	/**
	 * Instantiates a new app sequence.
	 *
	 * @param sequence the sequence
	 */
	public Sequence(List sequence) {
		super();

		this.sequence = sequence;
		// logger.debug("Application sequence initialised");
	}

	/* (non-Javadoc)
	 * @see org.stepper.control.AbstractTask#getName()
	 */
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return Sequence.NAME;
	}

	/* (non-Javadoc)
	 * @see org.stepper.control.AbstractTask#execute(java.util.HashMap)
	 */
	@Override
	public boolean execute(HashMap ValueStack)
			throws ComponentExecutionException {
		boolean success = false;
		try {
			start(ValueStack);
			success = true;
		} catch (AppSequenceException e) {
			//e.printStackTrace();
			success = false;
			throw new ComponentExecutionException(e);
		}
		return success;
	}

}

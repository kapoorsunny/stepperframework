package org.stepper.control;

import java.util.HashMap;

import org.stepper.exception.ComponentExecutionException;
import org.stepper.interfaces.ErrorHandler;
import org.stepper.interfaces.Task;
import org.stepper.interfaces.TransactionalTask;

/**
 * The Class AbstractEndTask.
 * Every Sequence should have End task. It provide an opportunity to cleanup for example value stack
 * The class represent the end of sequence of the flow
 *
 * Author: Abhishek kapoor
 * 21 Jun, 2013
 */
public abstract class AbstractEndTask implements Task,TransactionalTask{
	
	

	/** The continue on error.
	 * If the folowing flag is true, execution of sequence will continue to the next after even in exception
	 *  */
	private boolean continueOnError=false;
	
	/** The name of the task */
	public static String NAME="AbstractEndTask";
	
	/** The error handler. */
	// Default error handler if no implementation is provided
	private ErrorHandler errorHandler= new ErrorHandler() {
		
		public void handle(HashMap valueStack) {
			System.err.println("Task["+getName()+"] got error, End task got killed, please check the error");
			
		}
	};

	/* (non-Javadoc)
	 * @see org.stepper.interfaces.Task#getName()
	 */
	public abstract String getName(); 

	/* (non-Javadoc)
	 * @see org.stepper.interfaces.Task#getErrorHandler()
	 */
	public ErrorHandler getErrorHandler() {
		return errorHandler;
	}

	/* (non-Javadoc)
	 * @see org.stepper.interfaces.Task#setErrorHandler(org.stepper.interfaces.ErrorHandler)
	 */
	public void setErrorHandler(ErrorHandler errorHandler) {
		this.errorHandler=errorHandler;
		
	}

	/* (non-Javadoc)
	 * @see org.stepper.interfaces.Task#getContinueOnError()
	 */
	public boolean getContinueOnError() {
			return false;
	}

	/* (non-Javadoc)
	 * @see org.stepper.interfaces.Task#setContinueOnError(boolean)
	 */
	public void setContinueOnError(boolean continueOnError) {
//	should not get set, hence forcing a halt to progress if a flow
		
	}
	
	/* (non-Javadoc)
	 * @see org.stepper.interfaces.TransactionalTask#rollBack(java.util.HashMap)
	 */
	public boolean rollBack(HashMap valueStack){
		//forceing no rollback for End task
		return true; 
	}

	/* (non-Javadoc)
	 * @see org.stepper.interfaces.Task#execute(java.util.HashMap)
	 */
	public abstract boolean execute(HashMap valueStack)
			throws ComponentExecutionException ;
		

}

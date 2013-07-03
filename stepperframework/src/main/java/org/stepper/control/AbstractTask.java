package org.stepper.control;

import java.util.HashMap;

import org.stepper.exception.ComponentExecutionException;
import org.stepper.interfaces.ErrorHandler;
import org.stepper.interfaces.Task;
import org.stepper.interfaces.TransactionalTask;

// TODO: Auto-generated Javadoc
/**
 * The Class AbstractTask.
 *  
 * Author: Abhishek kapoor
 * 21 Jun, 2013
 */
public abstract class AbstractTask implements Task{

	/** The continue on error. */
	private boolean continueOnError=false;
	
	/** The name. */
	public static String NAME="AbstractTask";
	
	/** The error handler. */
	// Default error handler, if not specified
	private ErrorHandler errorHandler= new ErrorHandler() {
		
		public void handle(HashMap valueStack) {
			System.err.println("Task["+getName()+"] got error, please handle Error in Errorhandler or fix the issue");
			
		}
	};
	

	/* (non-Javadoc)
	 * @see org.stepper.interfaces.Task#getName()
	 */
	public abstract String getName() ;


	
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
		this.errorHandler = errorHandler;
	}


	/* (non-Javadoc)
	 * @see org.stepper.interfaces.Task#getContinueOnError()
	 */
	public boolean getContinueOnError() {
		return continueOnError;
	}


	/* (non-Javadoc)
	 * @see org.stepper.interfaces.Task#setContinueOnError(boolean)
	 */
	public void setContinueOnError(boolean continueOnError) {
		this.continueOnError = continueOnError;
	}


	/* (non-Javadoc)
	 * @see org.stepper.interfaces.Task#execute(java.util.HashMap)
	 */
	public abstract boolean execute(HashMap ValueStack)
			throws ComponentExecutionException;
	


}

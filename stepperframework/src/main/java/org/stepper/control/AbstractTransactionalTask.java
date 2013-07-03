package org.stepper.control;

import java.util.HashMap;

import org.stepper.exception.ComponentExecutionException;
import org.stepper.interfaces.ErrorHandler;
import org.stepper.interfaces.TransactionalTask;

// TODO: Auto-generated Javadoc
/**
 * The Class AbstractTransactionalTask.
 * This class will be used for transactional task  
 * Author: Abhishek kapoor
 * 21 Jun, 2013
 */
public abstract class AbstractTransactionalTask implements TransactionalTask{

	
	/* (non-Javadoc)
	 * @see org.stepper.interfaces.TransactionalTask#getName()
	 */
	public abstract String getName() ;
	private  boolean continueOnError=false;	
	private  ErrorHandler errorHandler = new ErrorHandler() {
	
	
		public void handle(HashMap ValueStack) {
			System.out.println("Setting default error handler");
			
		}
	};

	
	public ErrorHandler getErrorHandler(){
		return errorHandler;
	}
	
	public void setErrorHandler(ErrorHandler errorHandler){
		this.errorHandler=errorHandler;
	}
	
	public boolean getContinueOnError(){
		return false;
	}
	public void setContinueOnError(boolean continueOnError){
		this.continueOnError=false;
	}
	
	/* (non-Javadoc)
	 * @see org.stepper.interfaces.TransactionalTask#execute(java.util.HashMap)
	 */
	public abstract boolean execute(HashMap ValueStack)
			throws ComponentExecutionException;
	
	/* (non-Javadoc)
	 * @see org.stepper.interfaces.TransactionalTask#rollBack(java.util.HashMap)
	 */
	public abstract boolean rollBack(HashMap valueStack);

}

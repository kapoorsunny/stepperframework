package org.stepper.interfaces;

import java.util.HashMap;

import org.stepper.exception.ComponentExecutionException;
 
/**
 * The Interface Task.
 * The task represent the task that will be executed in the non transactional sequence in the framework
 * Author: Abhishek kapoor
 * 21 Jun, 2013
 */
public interface Task {
	
	
	/**
	 * Represent the name of the task
	 */
	public static String NAME="Task";
	
	/**
	 * Returns the name of the task.
	 *
	 * @return the name
	 */
	String getName();
	
	/**
	 * Gets the error handler if set in configuration xml.
	 * Handler will called in case of exception caused in task
	 * @return the error handler
	 */
	public ErrorHandler getErrorHandler();
	
	/**
	 * Sets the error handler.
	 *
	 * @param errorHandler the new error handler
	 */
	public void setErrorHandler(ErrorHandler errorHandler);
	
	/**
	 * It allows the execution to continues to the next task even if the task failure.
	 *
	 * @return the continue on error
	 */
	public boolean getContinueOnError();
	
	/**
	 * Sets the continue on error.
	 *
	 * @param continueOnError the new continue on error
	 */
	public void setContinueOnError(boolean continueOnError);
	
	/**
	 * Execute.
	 * This function will be called by Application sequence. 
	 * @param valueStack the value stack
	 * @return true, if successful
	 * @throws ComponentExecutionException the component execution exception
	 */
	boolean execute(HashMap valueStack)throws ComponentExecutionException;
}

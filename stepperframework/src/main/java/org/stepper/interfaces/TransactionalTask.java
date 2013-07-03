package org.stepper.interfaces;

import java.util.HashMap;

import org.stepper.exception.ComponentExecutionException;

// TODO: Auto-generated Javadoc
/**
 * The Interface TransactionalTask.
 * This interface provides the functionality to provide trasactional task, that in case for failure while executing the same
 * task rollback method will be called.
 * 
 * Author: Abhishek kapoor
 * 21 Jun, 2013
 */
public interface TransactionalTask extends Task{
	
	/**
	 * Gets the name of the transactional task.
	 *
	 * @return the name
	 */
	String getName();

	/**
	 * Execute. this functions perform the heavy loading of all the task.
	 *	
	 * @param valueStack the value stack
	 * @return true, if successful
	 * @throws ComponentExecutionException the component execution exception
	 */
	boolean execute(HashMap valueStack)throws ComponentExecutionException;
	
	/**
	 * Roll back functional will be called if execute function fails or throws the error.
	 *
	 * @param valueStack the value stack
	 * @return true, if successful
	 */
	public boolean rollBack(HashMap valueStack) throws ComponentExecutionException;
}

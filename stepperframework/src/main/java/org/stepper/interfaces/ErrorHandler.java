package org.stepper.interfaces;

import java.util.HashMap;

// TODO: Auto-generated Javadoc
/**
 * It will be used to if user needs to provide custom exception.
 *
 * @author Abhishek kapoor
 */
public interface ErrorHandler {
	
	/**
	 * in case of exception and if errorhandler is set in xml then handle method of Errorhandler will be called.
	 *
	 * @param ValueStack the value stack
	 */
	public void handle(HashMap ValueStack);
}

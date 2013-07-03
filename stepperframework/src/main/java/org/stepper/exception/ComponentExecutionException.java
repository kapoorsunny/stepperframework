package org.stepper.exception;

// TODO: Auto-generated Javadoc
/**
 * The Class ComponentExecutionException.
 *
 * Author: Abhishek kapoor
 * 21 Jun, 2013
 */
public class ComponentExecutionException extends Exception{
	
	/** The message. */
	private String message;
	
	/** The exception. */
	private Exception exception;
	
	/**
	 * Instantiates a new component execution exception.
	 *
	 * @param message the message
	 * @param exception the exception
	 */
	public ComponentExecutionException(String message, Exception exception) {
		super();
		this.message = message;
		this.exception = exception;
	}
	
	/**
	 * Instantiates a new component execution exception.
	 *
	 * @param exception the exception
	 */
	public ComponentExecutionException(Exception exception) {
		super();
		this.message = "";
		this.exception = exception;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Throwable#getMessage()
	 */
	public String getMessage() {
		if (exception != null) {
			message = message + ": " + exception.getMessage();
		}
		return message;
	}

	/**
	 * Instantiates a new component execution exception.
	 *
	 * @param message the message
	 */
	public ComponentExecutionException(String message) {
		super();
		this.message = message;
	}
}

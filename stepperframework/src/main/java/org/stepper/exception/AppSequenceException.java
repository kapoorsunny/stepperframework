package org.stepper.exception;

// TODO: Auto-generated Javadoc
/**
 * The Class AppSequenceException.
 *
 * Author: Abhishek kapoor
 * 21 Jun, 2013
 */
public class AppSequenceException extends Exception{
	
	/** The message. */
	private String message;
	
	/** The exception. */
	private Exception exception;
	
	/**
	 * Instantiates a new app sequence exception.
	 *
	 * @param message the message
	 * @param exception the exception
	 */
	public AppSequenceException(String message, Exception exception) {
		super();
		this.message = message;
		this.exception = exception;
	}
	
	
	/**
	 * Instantiates a new app sequence exception.
	 *
	 * @param exception the exception
	 */
	public AppSequenceException(Exception exception) {
		super();
		this.message = "";
		this.exception = exception;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Throwable#getMessage()
	 */
	public String getMessage() {
		/*if (exception != null) {
			message = message + ": " + exception.getMessage();
		}*/
		return message;
	}

	/**
	 * Instantiates a new app sequence exception.
	 *
	 * @param message the message
	 */
	public AppSequenceException(String message) {
		super();
		this.message = message;
	}

}

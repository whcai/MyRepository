package com.demo.common;

public class InvalidException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidException() {
		super();
	}

	
	public InvalidException(String message) {
		super(message);
	}

	public InvalidException(String message, Throwable cause) {
		super(message, cause);
	}

	public InvalidException(Throwable cause) {
		super(cause);
	}

	protected InvalidException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}

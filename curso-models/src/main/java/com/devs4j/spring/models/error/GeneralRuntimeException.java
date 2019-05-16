/**
 * 
 */
package com.devs4j.spring.models.error;

/**
 * @author raidentrance
 *
 */
public class GeneralRuntimeException extends RuntimeException {

	private static final long serialVersionUID = -1052678043903346300L;

	public GeneralRuntimeException(String message, Throwable cause) {
		super(message, cause);
	}
	public GeneralRuntimeException(String message) {
		super(message);
	}

}

/**
 * 
 */
package com.devs4j.spring.models.error;

/**
 * @author maagapi
 *
 */
public class AuthenticationFailedException extends RuntimeException {

	private static final long serialVersionUID = 6868619581374405704L;

	public AuthenticationFailedException(String message) {
		super(message);
	}

}

/**
 * 
 */
package com.devs4j.spring.models.error;

/**
 * @author raidentrance
 *
 */
public class PostNotFoundException extends Exception {

	private static final long serialVersionUID = -4204129803805634675L;

	public PostNotFoundException(String message) {
		super(message);
	}

}

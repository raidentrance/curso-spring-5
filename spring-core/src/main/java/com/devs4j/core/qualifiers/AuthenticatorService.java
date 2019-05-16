/**
 * 
 */
package com.devs4j.core.qualifiers;

import com.devs4j.spring.models.credentials.User;

/**
 * @author maagapi
 *
 */
public interface AuthenticatorService {

	public User authenticate(String username, String password);
	
}

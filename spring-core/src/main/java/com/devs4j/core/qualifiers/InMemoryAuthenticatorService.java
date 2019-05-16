/**
 * 
 */
package com.devs4j.core.qualifiers;

import org.springframework.stereotype.Service;

import com.devs4j.spring.models.credentials.User;
import com.devs4j.spring.models.error.AuthenticationFailedException;

/**
 * @author maagapi
 *
 */
@Service("inMemoryAuthenticator")
public class InMemoryAuthenticatorService implements AuthenticatorService {

	private User user = new User("admin", "admin", true);

	@Override
	public User authenticate(String username, String password) {
		if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
			return user;
		} else {
			throw new AuthenticationFailedException("Wrong credentials ");
		}
	}

}

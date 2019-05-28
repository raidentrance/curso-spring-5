/**
 * 
 */
package com.devs4j.core.qualifiers;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.devs4j.spring.models.credentials.User;
import com.devs4j.spring.models.error.AuthenticationFailedException;

/**
 * @author maagapi
 *
 */
@Service("listAuthenticator")
public class ListAuthenticatorService implements AuthenticatorService {

	private List<User> users = new ArrayList<>();

	@PostConstruct
	private void init() {
		users.add(new User("admin", "admin", true));
		users.add(new User("admin", "admin123", true));
		users.add(new User("user", "password", true));
		users.add(new User("admin", "12345678", true));
	}

	@Override
	public User authenticate(String username, String password) {
		return users.stream().filter(u -> u.getUsername().equals(username) && u.getPassword().equals(password))
				.findAny().orElseThrow(() -> new AuthenticationFailedException("Wrong credentials"));
	}

}

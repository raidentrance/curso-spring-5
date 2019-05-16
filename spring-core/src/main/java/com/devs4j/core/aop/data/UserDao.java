/**
 * 
 */
package com.devs4j.core.aop.data;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Repository;

import com.devs4j.spring.models.credentials.User;
import com.devs4j.spring.models.error.AuthenticationFailedException;

/**
 * @author maagapi
 *
 */
@Repository
public class UserDao {
	public List<User> users;

	@PostConstruct
	public void init() {
		users = new ArrayList<>();
		users.add(new User("raidentrance", "SuperSecret", true));
		users.add(new User("pepePecas", "picaPapas", true));
		users.add(new User("arnold", "Chuaheneguer", true));
	}

	public User findByUsername(String username) {
		return users.stream().filter(u -> u.getUsername().equals(username)).findFirst().orElse(null);
	}

	public User authenticate(String username, String password) {
		Optional<User> user = users.stream()
				.filter(u -> u.getUsername().equals(username) && u.getPassword().equals(password)).findFirst();
		if (user.isPresent()) {
			return user.get();
		} else {
			throw new AuthenticationFailedException(String.format("Authentication failure for %s", username));
		}
	}

	public User authenticate(String clientId, String clientSecret, String transaction) {
		throw new UnsupportedOperationException("Unsupported operation ");
	}
}

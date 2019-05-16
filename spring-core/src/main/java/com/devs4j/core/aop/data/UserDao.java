/**
 * 
 */
package com.devs4j.core.aop.data;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Repository;

import com.devs4j.spring.models.credentials.User;

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
}

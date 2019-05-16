/**
 * 
 */
package com.devs4j.spring.models.credentials;

/**
 * @author maagapi
 *
 */
public class User {

	private String username;
	private String password;
	private boolean active;

	public User() {
	}

	public User(String username, String password, boolean active) {
		this.username = username;
		this.password = password;
		this.active = active;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", active=" + active + "]";
	}

}

/**
 * 
 */
package com.devs4j.core.qualifiers;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.devs4j.spring.models.credentials.User;
import com.devs4j.spring.models.error.AuthenticationFailedException;

/**
 * @author maagapi
 *
 */

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = { InMemoryAuthenticatorService.class, ListAuthenticatorService.class })
public class QualifiersTest {

	@Autowired
	@Qualifier("inMemoryAuthenticator")
	private AuthenticatorService inMemoryAuthenticator;
	@Autowired
	@Qualifier("listAuthenticator")
	private AuthenticatorService listAuthenticator;

	@Test
	public void simpleTest() {
		User user = inMemoryAuthenticator.authenticate("admin", "admin");
		assertNotNull(user);
	}

	@Test(expected = AuthenticationFailedException.class)
	public void simple_InvalidUserTest() {
		User user = inMemoryAuthenticator.authenticate("admin", "admin123");
		assertNotNull(user);
	}

	@Test
	public void simple_listUserTest() {
		User user = listAuthenticator.authenticate("admin", "admin123");
		assertNotNull(user);
	}

	@Test(expected = AuthenticationFailedException.class)
	public void simple_listInvalidUserTest() {
		User user = listAuthenticator.authenticate("adminas", "admin123");
		assertNotNull(user);
	}
}

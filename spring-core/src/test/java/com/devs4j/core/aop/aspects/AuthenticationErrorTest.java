/**
 * 
 */
package com.devs4j.core.aop.aspects;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.devs4j.core.aop.data.UserDao;
import com.devs4j.spring.models.error.AuthenticationFailedException;

/**
 * @author maagapi
 *
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = { UserDao.class, AuthenticationErrorCounterAspect.class })
@EnableAspectJAutoProxy

public class AuthenticationErrorTest {

	@Autowired
	private UserDao userDao;

	private static final Logger log = LoggerFactory.getLogger(AuthenticationErrorTest.class);

	@Test
	public void simple_ExceptionCounter() {
		try {
			userDao.authenticate("raidentrance", "wrongPassword");
		} catch (AuthenticationFailedException ex) {
			log.info("Error authenticating {} ", ex.getMessage());
		}
		try {
			userDao.authenticate("raidentrance", "wrongPassword");
		} catch (AuthenticationFailedException ex) {
			log.info("Error authenticating {} ", ex.getMessage());
		}
		try {
			userDao.authenticate("raidentrance", "wrongPassword");
		} catch (AuthenticationFailedException ex) {
			log.info("Error authenticating {} ", ex.getMessage());
		}
		try {
			userDao.authenticate("raidentrance", "wrongPassword", "1110345");
		} catch (UnsupportedOperationException ex) {
			log.info("Error authenticating {} ", ex.getMessage());
		}

		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			log.info("Error sleeping {} ", e.getMessage());
		}
	}
}

/**
 * 
 */
package com.devs4j.core.aop.aspects;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.devs4j.core.aop.data.UserDao;
import com.devs4j.spring.models.credentials.User;

/**
 * @author maagapi
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = { HidePasswordAfterUserExecutionAspect.class, UserDao.class })
@EnableAutoConfiguration
public class HidePasswordAspectTest {

	@Autowired
	private UserDao userDao;

	private static final Logger log = LoggerFactory.getLogger(HidePasswordAspectTest.class);

	@Test
	public void simple_testPasswordHashing() {
		User user = userDao.findByUsername("raidentrance");
		assertNotNull(user);
		assertNotEquals("SuperSecret", user.getPassword());
		log.info("User's password hashed {} ", user.getPassword());
	}
}

/**
 * 
 */
package com.devs4j.core.scopes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author maagapi
 *
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = { SingletonBean.class, PrototypeBean.class })
public class BeanScopesTest {

	@Autowired
	private SingletonBean singleton1;
	@Autowired
	private SingletonBean singleton2;

	@Autowired
	private PrototypeBean prototype1;
	@Autowired
	private PrototypeBean prototype2;

	@Test
	public void test_singletonEquality() {
		assertEquals(singleton1, singleton2);
	}

	@Test
	public void test_prototypeEquality() {
		assertNotEquals(prototype1, prototype2);
	}
}

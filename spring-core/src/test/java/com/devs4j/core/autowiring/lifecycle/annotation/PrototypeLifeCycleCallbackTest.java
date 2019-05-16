/**
 * 
 */
package com.devs4j.core.autowiring.lifecycle.annotation;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.devs4j.core.autowiring.lifecycle.annotations.PrototypeLifeCycleCallback;

/**
 * @author maagapi
 *
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = { PrototypeLifeCycleCallback.class })
public class PrototypeLifeCycleCallbackTest {

	@Autowired
	private PrototypeLifeCycleCallback bean;

	/**
	 * Este método demuestra que los beans con scope prototype no ejecutan los
	 * métodos anotados con @PostConstruct
	 * 
	 */
	@Test
	public void basticTest() {
		bean.foo();
	}
}

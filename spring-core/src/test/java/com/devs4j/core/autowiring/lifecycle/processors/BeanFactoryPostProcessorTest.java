/**
 * 
 */
package com.devs4j.core.autowiring.lifecycle.processors;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.devs4j.core.autowiring.lifecycle.NotInSpringBean;

/**
 * 
 * :o como se inyectó un bean que no está anotado con @Component de forma correcta?
 * 
 * @author maagapi
 *
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = { PostProcessor.class })
public class BeanFactoryPostProcessorTest {

	@Autowired
	private NotInSpringBean bean;

	@Test
	public void emptyTest() {
		bean.foo();
	}
}

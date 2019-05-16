/**
 * 
 */
package com.devs4j.core.autowiring.lifecycle.interfaces;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author maagapi
 *
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = { BeanInterfacesExample.class })
public class BeanInterfacesExampleTest {

	@Test
	public void emptyTest() {

	}
}

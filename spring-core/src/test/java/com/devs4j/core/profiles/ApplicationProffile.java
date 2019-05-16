/**
 * 
 */
package com.devs4j.core.profiles;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 
 * También se puede definir el ambiente en el application.properties
 * spring.profiles.acrive=dev
 * @author maagapi
 *
 */

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {  ProdEnvironment.class, DevEnvironment.class,
		QaEnvironment.class })
@ActiveProfiles("dev")
public class ApplicationProffile {

	@Autowired
	private ApplicationEnvironment applicationEnvironment;

	@Test
	public void simpleTest() {
		String environment = applicationEnvironment.getEnvironment();
		assertEquals("dev", environment);
	}
}

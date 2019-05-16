/**
 * 
 */
package com.devs4j.core.autowiring.environment;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.devs4j.core.autowiring.environments.EnvironmentInjection;

/**
 * @author raidentrance
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes={EnvironmentInjection.class})
@EnableAutoConfiguration
public class TestEnvironmentInjection {
	
	@Autowired
	private EnvironmentInjection environmentInjection; 
	
	@Test
	public void tesApplicationName(){
		assertEquals("Devs4j Application", environmentInjection.getApplciationName());
	}
}

package com.devs4j.autowiring;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.devs4j.spring.config.StringConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { StringConfiguration.class })
@ActiveProfiles("stg")
public class StringConfigurationTest {

	@Autowired
	private List<String> names;

	@Autowired
	private Map<String, String> palabras;

	private static final Logger log = LoggerFactory.getLogger(StringConfigurationTest.class);

	/**
	 * Hay 4 beans de tipo string que se pueden inyectar, pero uno de ellos solo se crerá 
	 * a través del perfil de dev 
	 */
	@Test
	public void testAutowiring() {
		assertThat(names.size()).isEqualTo(3);
	}
	
	/**
	 * Hay 4 beans de tipo string que se pueden inyectar, pero uno de ellos solo se crerá 
	 * a través del perfil de dev 
	 */
	@Test
	public void testMapAutowiring() {
		for (String key : palabras.keySet()) {
			log.info("Palabra {} significado {} ", key, palabras.get(key));
		}
		assertThat(palabras.size()).isEqualTo(3);
	}
}

package com.devs4j.core.profiles;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { DevEnvironment.class, StagingEnvironment.class, ProdEnvironment.class })
@ActiveProfiles("dev")
@EnableAutoConfiguration
public class EnvironmentProfileTests {

	@Autowired(required = false)
	@Qualifier("devEnvironment")
	private Environment devEnvironment;

	@Autowired(required = false)
	@Qualifier("stagingEnvironment")
	private Environment stgEnvironment;

	@Autowired(required = false)
	@Qualifier("prodEnvironment")
	private Environment prodEnvironment;

	@Test
	public void testEnvironment() {
		assertThat(devEnvironment).isNotNull();
		assertThat(stgEnvironment).isNull();
		assertThat(prodEnvironment).isNull();
	}
}

package com.devs4j.core.services.autowired.environments;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class EnvironmentInjection {

	@Autowired
	private Environment environment;

	public String getApplciationName() {
		return environment.getProperty("com.devs4j.name");
	}
}

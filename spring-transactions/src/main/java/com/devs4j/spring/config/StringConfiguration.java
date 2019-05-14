package com.devs4j.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class StringConfiguration {

	@Bean
	@Profile("dev")
	public String getName() {
		return "Alex";
	}

	@Bean
	public String getName2() {
		return "Juan";
	}

	@Bean
	public String getName3() {
		return "Pedro";
	}

	@Bean
	public String getName4() {
		return "Julian";
	}


}

package com.devs4j.core.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 
 * @author maagapi
 *
 */
@Configuration
public class JacksonConfig {
	
	
	@Bean
	public ObjectMapper getObjectMapper() {
		return new ObjectMapper();
	}
}

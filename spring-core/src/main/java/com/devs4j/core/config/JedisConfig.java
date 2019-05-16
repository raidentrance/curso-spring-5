package com.devs4j.core.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import redis.clients.jedis.Jedis;

/**
 * 
 * @author raidentrance
 *
 */
@Configuration
public class JedisConfig {
	@Bean
	public Jedis getJedisClient() {
		return new Jedis("localhost");
	}
}

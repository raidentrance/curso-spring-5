package com.devs4j.spring.data.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 
 * @author raidentrance
 *
 */
@Configuration
@EnableJpaRepositories("com.devs4j.spring.data.repositories")
@EnableTransactionManagement
public class JpaConfiguration {

}

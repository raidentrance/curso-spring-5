package com.devs4j.spring.data;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.devs4j.spring.data.service.PersonService;

@SpringBootApplication
public class SpringDataApplication {

	public static void main(String[] args) throws Exception {
		ConfigurableApplicationContext context = SpringApplication.run(SpringDataApplication.class, args);
		PersonService personService = context.getBean(PersonService.class);
		personService.performDatabaseOperations();
	}
}

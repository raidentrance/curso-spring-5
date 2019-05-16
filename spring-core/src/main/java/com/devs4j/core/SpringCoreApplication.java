package com.devs4j.core;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.devs4j.core.aop.data.PersonComplexDao;
import com.devs4j.core.services.autowired.lifecycle.NotInSpringBean;
import com.devs4j.spring.models.people.Person;

@SpringBootApplication
public class SpringCoreApplication {

	private static final Logger log = LoggerFactory.getLogger(SpringCoreApplication.class);

	public static void beanFactoryProcessorExample(ApplicationContext applicationContext) {
		NotInSpringBean combinationBean = applicationContext.getBean(NotInSpringBean.class);
		combinationBean.foo();
	}

	public static void beforeAdvice(ApplicationContext applicationContext) {
		PersonComplexDao personDao = applicationContext.getBean(PersonComplexDao.class);
		List<Person> people = personDao.findAll();
		log.info("All people {} ", people);
		Optional<Person> person = personDao.findByName("Alex");
		if (person.isPresent()) {
			log.info("Person exists {} ", person.get());
		} else {
			log.info("Person not found");
		}

	}

	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext = SpringApplication.run(SpringCoreApplication.class, args);
	}

}

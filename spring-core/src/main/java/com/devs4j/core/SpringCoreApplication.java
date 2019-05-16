package com.devs4j.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.devs4j.core.aop.data.UserDao;
import com.devs4j.core.services.autowired.lifecycle.NotInSpringBean;
import com.devs4j.spring.models.credentials.User;

@SpringBootApplication
public class SpringCoreApplication {

	private static final Logger log = LoggerFactory.getLogger(SpringCoreApplication.class);

	public static void beanFactoryProcessorExample(ApplicationContext applicationContext) {
		NotInSpringBean combinationBean = applicationContext.getBean(NotInSpringBean.class);
		combinationBean.foo();
	}

	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext = SpringApplication.run(SpringCoreApplication.class, args);

		UserDao userDao = applicationContext.getBean(UserDao.class);
		User user = userDao.findByUsername("raidentrance");

		log.info("User information {} ", user);
	}

}

package com.devs4j.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.devs4j.core.aop.service.HelloWorldService;
import com.devs4j.core.services.autowired.lifecycle.NotInSpringBean;

@SpringBootApplication
public class SpringCoreApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext = SpringApplication.run(SpringCoreApplication.class, args);
		NotInSpringBean combinationBean = applicationContext.getBean(NotInSpringBean.class);
		combinationBean.foo();
		
		HelloWorldService helloWorldService = applicationContext.getBean(HelloWorldService.class);
		helloWorldService.hello();
	}

}

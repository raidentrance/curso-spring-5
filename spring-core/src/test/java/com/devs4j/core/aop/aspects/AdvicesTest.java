package com.devs4j.core.aop.aspects;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.devs4j.core.aop.aspects.LoggerAspectExample;
import com.devs4j.core.aop.service.HelloWorldService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes={LoggerAspectExample.class,HelloWorldService.class})
@EnableAutoConfiguration
public class AdvicesTest {
	@Autowired
	private HelloWorldService helloWorldService;
	
	@Test
	public void test_hello(){
		helloWorldService.hello("Alex");
	}
}

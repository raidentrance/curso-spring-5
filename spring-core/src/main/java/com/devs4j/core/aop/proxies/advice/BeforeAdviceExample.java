package com.devs4j.core.aop.proxies.advice;

import java.lang.reflect.Method;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.MethodBeforeAdvice;

public class BeforeAdviceExample implements MethodBeforeAdvice{
	
	
	private static final Logger log = LoggerFactory.getLogger(BeforeAdviceExample.class);

	@Override
	public void before(Method method, Object[] args, Object target) throws Throwable {
		log.info("Before advice");
	}

}

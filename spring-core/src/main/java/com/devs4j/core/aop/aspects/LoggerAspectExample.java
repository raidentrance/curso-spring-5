package com.devs4j.core.aop.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggerAspectExample {

	private static final Logger log = LoggerFactory.getLogger(LoggerAspectExample.class);

	@Before("execution(* com.devs4j.core.aop.*.*.*(..))")
	public void printBefore(JoinPoint joinPoint) {
		log.info("Before advice for method {}", joinPoint.getSignature().getName());
		Object[] args = joinPoint.getArgs();
		for (Object arg : args) {
			log.info("arg = {}", arg);
		}
	}
}

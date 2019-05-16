package com.devs4j.core.aop.advices;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class BeforeAdviceExample {

	private static final Logger log = LoggerFactory.getLogger(BeforeAdviceExample.class);

	@Before("execution(* com.devs4j.core.aop.data.PersonComplexDao.*(..))")
	public void printBefore(JoinPoint joinPoint) {
		log.info("Before advice for method {}", joinPoint.getSignature().getName());
		Object[] args = joinPoint.getArgs();

		for (Object arg : args) {
			log.info("arg = {}", arg);
		}
	}
}

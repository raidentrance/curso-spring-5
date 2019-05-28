package com.devs4j.core.aop.aspects;

import java.util.HashMap;
import java.util.Map;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 
 * @author maagapi
 *
 */

@Component
@Aspect
@EnableScheduling
public class AuthenticationErrorCounterAspect {

	private Map<String, Integer> amountOfExceptions = new HashMap<>();

	private static final Logger log = LoggerFactory.getLogger(AuthenticationErrorCounterAspect.class);

	@AfterThrowing(pointcut = "execution(com.devs4j.spring.models.credentials.User com.devs4j.core.aop.data.*.*(..))", throwing = "ex")
	public void logAfterThrowing(JoinPoint joinPoint, Exception ex) {
		log.info("An exception {} occured", ex.getMessage());
		Integer counter = amountOfExceptions.get(ex.getClass().getName());
		if (counter == null) {
			amountOfExceptions.put(ex.getClass().getName(), 1);
		} else {
			amountOfExceptions.put(ex.getClass().getName(), counter+1);
		}
	}

	@Scheduled(fixedDelay = 5000)
	public void printExceptionReport() {
		log.info("The following are the exceptions generated in the 5 seconds");
		for (String exception : amountOfExceptions.keySet()) {
			log.info("Exception {} amount {} ", exception, amountOfExceptions.get(exception));
		}
	}
}

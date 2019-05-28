/**
 * 
 */
package com.devs4j.core.aop.aspects;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.devs4j.spring.models.credentials.User;

/**
 * @author maagapi
 *
 */
@Aspect
@Component
public class HidePasswordAfterUserExecutionAspect {

	private static final Logger log = LoggerFactory.getLogger(HidePasswordAfterUserExecutionAspect.class);

	@AfterReturning(pointcut = "execution(com.devs4j.spring.models.credentials.User com.devs4j.core.aop.data.*.*(..))", returning = "user")
	public void hidePassword(JoinPoint joinPoint, User user) {
		if (user != null) {
			log.info("Hiding password information for {}", user.getUsername());
			user.setPassword(hashPassword(user.getPassword()));
		}
	}

	private String hashPassword(String password) {
		MessageDigest digest;
		try {
			digest = MessageDigest.getInstance("SHA-256");
			return new String(digest.digest(password.getBytes(StandardCharsets.UTF_8)));
		} catch (NoSuchAlgorithmException e) {
			throw new IllegalStateException("Algorithm for caching doesn't exist ", e);
		}
	}
}

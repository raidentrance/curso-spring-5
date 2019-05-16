package com.devs4j.core.aop.advices;

import java.io.IOException;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.devs4j.core.aop.annotation.Devs4jCache;
import com.devs4j.spring.models.error.GeneralRuntimeException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import redis.clients.jedis.Jedis;

/**
 * 
 * @author raidentrance
 *
 */
@Component
@Aspect
public class CacheAroundAdvice {

	@Autowired
	private Jedis client;

	private ObjectMapper mapper = new ObjectMapper();

	@Around("@annotation(com.devs4j.core.aop.annotation.Devs4jCache)")
	public Object cache(ProceedingJoinPoint joinPoint) throws Throwable {
		Devs4jCache annotation = getAnnotationFromSignature(joinPoint);
		String collection = annotation.collection();
		String key = getFirstStringArgument(joinPoint);
		if (key != null) {
			Object result = getFromCache(collection, key, annotation.annotationType());
			if (result != null) {
				return result;
			} else {
				return saveInCache(collection, key, joinPoint.proceed());
			}
		} else {
			return joinPoint.proceed();
		}
	}

	public Object getFromCache(String collection, String key, Class<?> type) {
		String response = client.get(getKeyFromCollectionAndKey(collection, key));
		if (response != null) {
			try {
				return mapper.readValue(response, type);
			} catch (IOException e) {
				throw new GeneralRuntimeException(String.format("Error retriving value from cache %s", key));
			}
		} else {
			return null;
		}
	}

	public Object saveInCache(String collection, String key, Object result) {
		try {
			client.set(getKeyFromCollectionAndKey(collection, key), mapper.writeValueAsString(result));
		} catch (JsonProcessingException e) {
			throw new GeneralRuntimeException(String.format("Error storing value in cache %s", key));
		}

		return null;
	}

	private String getKeyFromCollectionAndKey(String collection, String key) {
		return String.format("%s-%s", collection, key);
	}

	private String getFirstStringArgument(ProceedingJoinPoint joinPoint) {
		return (joinPoint.getArgs()[0] != null) ? joinPoint.getArgs()[0].toString() : null;
	}

	public Devs4jCache getAnnotationFromSignature(ProceedingJoinPoint joinPoint) {
		MethodSignature signature = (MethodSignature) joinPoint.getSignature();
		return signature.getMethod().getAnnotation(Devs4jCache.class);
	}
}

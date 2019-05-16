/**
 * 
 */
package com.devs4j.core.aop.annotation;

import static java.lang.annotation.ElementType.METHOD;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author raidentrance
 *
 */
@Target(METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Devs4jCache {
	String collection();
	Class<?> classType();
}

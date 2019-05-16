/**
 * 
 */
package com.devs4j.core.aop.annotation;

import static java.lang.annotation.ElementType.METHOD;

import java.lang.annotation.Target;

@Target(METHOD)
/**
 * @author raidentrance
 *
 */
public @interface Devs4jCache {
	String collection();
	Class<?> classType();
}

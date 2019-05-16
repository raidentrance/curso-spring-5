/**
 * 
 */
package com.devs4j.core.autowiring.lifecycle.processors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import com.devs4j.core.autowiring.lifecycle.combination.CombinationBean;

/**
 * 
 * @author raidentrance
 *
 */
@Component
public class AuditNameBeanProcessor implements BeanPostProcessor {

	private static final Logger log = LoggerFactory.getLogger(AuditNameBeanProcessor.class);

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		if(bean instanceof CombinationBean){
			log.info("Post process before initialization {}",beanName);
		}
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		if(bean instanceof CombinationBean){
			log.info("Post process after initialization {}",beanName);
		}
		return bean;
	}

}

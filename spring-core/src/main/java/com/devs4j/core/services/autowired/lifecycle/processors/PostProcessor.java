package com.devs4j.core.services.autowired.lifecycle.processors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

import com.devs4j.core.services.autowired.lifecycle.NotInSpringBean;

/**
 * 
 * @author raidentrance
 *
 */
@Component
public class PostProcessor implements BeanFactoryPostProcessor{
	
	private static final Logger log = LoggerFactory.getLogger(PostProcessor.class);

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		log.info("Destroying bean by bean factory post processor");
		beanFactory.registerSingleton("notInSpring", new NotInSpringBean());
		log.info("Bean destroyed by bean factory post processor");
		
	}

}

package com.devs4j.core.autowiring.lifecycle.annotations;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
/**
 * Por default los singleton beans son eager
 * 
 * @author raidentrance
 *
 */
@Lazy(true)
public class SingletonLifeCycleCallbacksBean {

	@Value("SingletonLifeCycleCallbacksBean")
	private String name;

	private static final Logger log = LoggerFactory.getLogger(SingletonLifeCycleCallbacksBean.class);

	@PostConstruct
	public void init() {
		log.info("Init Post construct bean");
	}

	@PreDestroy
	public void end() {
		log.info("Predestroy bean ");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}

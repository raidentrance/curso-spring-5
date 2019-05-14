package com.devs4j.core.services.autowired.lifecycle;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NotInSpringBean {
		
	private static final Logger log = LoggerFactory.getLogger(NotInSpringBean.class);
	
	@PostConstruct
	public void init(){
		log.info("Initializing not in spring bean");
	}
	
	public void foo(){
		log.info("Foo");
	}
	
	public void destroy(){
		log.info("Destroying not in spring bean");
	}
}

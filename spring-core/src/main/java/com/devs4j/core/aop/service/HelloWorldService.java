package com.devs4j.core.aop.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class HelloWorldService {
	
	
	private static final Logger log = LoggerFactory.getLogger(HelloWorldService.class);

	public void hello(String name){
		log.info("Hello world service {}",name);
	}
}

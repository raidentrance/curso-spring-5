package com.devs4j.core.autowiring.lifecycle.combination;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component
public class CombinationBean implements InitializingBean, DisposableBean {

	private static final Logger log = LoggerFactory.getLogger(CombinationBean.class);

	@Override
	public void afterPropertiesSet() throws Exception {
		log.info("After properties");
	}

	@PostConstruct
	public void init() {
		log.info("Post construct");
	}

	public void foo() {
		log.info("Foo");
	}

	@PreDestroy
	public void end() {
		log.info("Pre destroy");
	}

	@Override
	public void destroy() throws Exception {
		log.info("destroy");

	}

}

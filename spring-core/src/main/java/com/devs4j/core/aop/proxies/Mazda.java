package com.devs4j.core.aop.proxies;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Mazda implements Coche {

	private static final Logger log = LoggerFactory.getLogger(Mazda.class);

	public void avanzar() {
		log.info("El coche esta avanzando");
	}
}

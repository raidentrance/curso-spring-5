package com.devs4j.core.autowiring.vehicle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 
 * @author maagapi
 *
 */
@Service
public class Engine {
	private static final Logger log = LoggerFactory.getLogger(Engine.class);

	public void turnOn() {
		log.info("Turning on the engine");
	}
}

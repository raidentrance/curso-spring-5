package com.devs4j.core.autowiring.vehicle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author maagapi
 *
 */
public class SteeringWheel {
	private static final Logger log = LoggerFactory.getLogger(SteeringWheel.class);

	public void goStraight() {
		log.info("Going straight");
	}
}
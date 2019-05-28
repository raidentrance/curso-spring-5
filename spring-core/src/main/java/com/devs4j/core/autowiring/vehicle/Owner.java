/**
 * 
 */
package com.devs4j.core.autowiring.vehicle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @author maagapi
 *
 */

@Service
public class Owner {
	private static final Logger log = LoggerFactory.getLogger(Owner.class);

	public void printOwnerName() {
		log.info("Owner name {} ", "Alex");
	}
}

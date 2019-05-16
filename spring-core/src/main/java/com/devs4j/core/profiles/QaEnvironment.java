/**
 * 
 */
package com.devs4j.core.profiles;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

/**
 * @author maagapi
 *
 */
@Component
@Profile("qa")
public class QaEnvironment implements ApplicationEnvironment {

	@Override
	public String getEnvironment() {
		return "qa";
	}

}

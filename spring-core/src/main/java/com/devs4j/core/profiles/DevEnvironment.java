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
@Profile("dev")
public class DevEnvironment implements ApplicationEnvironment {

	@Override
	public String getEnvironment() {
		return "dev";
	}

}

/**
 * 
 */
package com.devs4j.core.profiles;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

/**
 * 
 * @author raidentrance
 *
 */
@Component
@Profile(value={"dev","local","default"})
@Primary
public class DevEnvironment implements ApplicationEnvironment {

	@Override
	public String getEnvironment() {
		return "dev";
	}

}

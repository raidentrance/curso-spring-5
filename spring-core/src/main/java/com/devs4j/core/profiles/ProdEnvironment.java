/**
 * 
 */
package com.devs4j.core.profiles;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

/**
 * @author raidentrance
 *
 */
@Component
@Profile("prod")
public class ProdEnvironment implements ApplicationEnvironment{

	@Override
	public String getEnvironment() {
		return "prod";
	}

}

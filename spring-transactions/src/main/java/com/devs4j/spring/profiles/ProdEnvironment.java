/**
 * 
 */
package com.devs4j.spring.profiles;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

/**
 * @author raidentrance
 *
 */
@Component("prodEnvironment")
@Profile("prod")
public class ProdEnvironment implements Environment {

	@Override
	public String getEnvironment() {
		return "prod";
	}

}

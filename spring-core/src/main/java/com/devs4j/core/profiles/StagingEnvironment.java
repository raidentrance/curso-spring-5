package com.devs4j.core.profiles;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

/**
 * 
 * @author raidentrance
 *
 */
@Profile("stg")
@Component
public class StagingEnvironment implements ApplicationEnvironment{

	@Override
	public String getEnvironment() {
		return "stg";
	}

}

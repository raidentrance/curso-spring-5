package com.devs4j.spring.profiles;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

/**
 * 
 * @author raidentrance
 *
 */
@Profile("stg")
@Component("stagingEnvironment")
public class StagingEnvironment implements Environment{

	@Override
	public String getEnvironment() {
		return "stg";
	}

}

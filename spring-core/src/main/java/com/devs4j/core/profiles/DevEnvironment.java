package com.devs4j.core.profiles;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

/**
 * 
 * @author raidentrance
 *
 */
@Component("devEnvironment")
@Profile(value={"dev","local","default"})
@Primary
public class DevEnvironment implements Environment {

	@Override
	public String getEnvironment() {
		return "dev";
	}

}

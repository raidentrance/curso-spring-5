/**
 * 
 */
package com.devs4j.core.autowiring.lifecycle.interfaces;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author raidentrance
 *
 */
@Component
public class BeanInterfacesExample implements InitializingBean, DisposableBean {

	@Value("BeanInterfacesExample")
	private String name;

	private static final Logger log = LoggerFactory.getLogger(BeanInterfacesExample.class);

	@Override
	public void afterPropertiesSet() throws Exception {
		log.info("After properties method");
	}

	@Override
	public void destroy() throws Exception {
		log.info("Destroy method");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}

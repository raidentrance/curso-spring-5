package com.devs4j.core.services.autowired.lifecycle.annotations;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * 
 * @author raidentrance
 *
 */
@Component
@Scope("prototype")
@Lazy(false)
/**
 * Lazy solo aplica a singleton, por tanto no cambiará el efecto lazy en un bean
 * de tipo prototype
 *
 */
public class PrototypeLifeCycleCallback {

	@Value("PrototypeLifeCycleCallbacksBean")
	private String name;

	private static final Logger log = LoggerFactory.getLogger(SingletonLifeCycleCallbacksBean.class);

	@PostConstruct
	public void init() {
		log.info("Prototype init method");

	}

	public void foo() {
		log.info("Foo");
	}

	@PreDestroy
	/**
	 * Pre destroy no funciona en prototype beans dado que este bean será
	 * elegible por el garbage colector una vez que se termina de utilizar.
	 */
	public void end() {
		log.info("Prototype end method");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}

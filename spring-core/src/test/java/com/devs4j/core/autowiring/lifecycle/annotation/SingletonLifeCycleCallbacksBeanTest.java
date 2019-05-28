/**
 * 
 */
package com.devs4j.core.autowiring.lifecycle.annotation;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.devs4j.core.autowiring.lifecycle.annotations.SingletonLifeCycleCallbacksBean;

/**
 * Puntos a analizar:
 * 
 * 	-Si se mantiene @Lazy(true) aunque en @ContextConfiguration defina que se utilizará SingletonLifeCycleCallbacksBean
 * 	el bean no se inicializará hasta que se inyecte.
 * 
 *  -En caso de colocar @Lazy(false) con el simple hecho de definir  SingletonLifeCycleCallbacksBean en @ContextConfiguration
 *  incluso si no se inyecta en el test el objecto ejecutará sus métodos definidos con @PostConstruct
 * 
 * @author maagapi
 *
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = { SingletonLifeCycleCallbacksBean.class })
public class SingletonLifeCycleCallbacksBeanTest {

	@Autowired
	private SingletonLifeCycleCallbacksBean bean;
	
	/**
	 * Los beans singleton si ejecutan sus métodos anotados con @PreDestroy
	 */
	@Test
	public void simpleTest() {
		assertEquals("SingletonLifeCycleCallbacksBean", bean.getName());
	}
}

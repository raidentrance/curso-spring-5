/**
 * 
 */
package com.devs4j.core.autowiring.lifecycle.combination;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 
 * El bean CombinationBean es inicializado sin necesidad de inyectarlo dado
 * que el valor por default para @Lazy() es false, entonces lo conoceremos como eager.
 * 
 * El flujo será el siguiente:
 * 	-Fase de inicialización
 * 		-Primero se ejecutan los métodos anotados con @PostConstruct
 * 		-Después se ejecuta el método afterProperties en caso de que el bean implemente InitializingBean
 * 	-Fase de destrucción
 * 		-Primero se ejecutarán los métodos anotados con @PreDestroy
 * 		-Después se ejecuta el método desroy en caso de que el bean implemente DisposableBean
 * 
 * @author maagapi
 *
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = { CombinationBean.class })
public class CombinationBeanTest {

	@Test
	public void emptyTest() {

	}
}

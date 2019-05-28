package com.devs4j.core.autowiring.lifecycle.processors;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.devs4j.core.autowiring.lifecycle.combination.CombinationBean;

/**
 * 
 * Analiza la salida y describe el ciclo de vida completo de un bean
 * 
 * @author maagapi
 *
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = { AuditNameBeanProcessor.class, CombinationBean.class })
public class AuditNameBeanProcessorTest {

	@Autowired
	private CombinationBean bean;

	@Test
	public void emptyTest() {
		bean.foo();
	}
}

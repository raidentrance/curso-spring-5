package com.devs4j.core.aop.proxies;

import org.junit.Test;
import org.springframework.aop.framework.ProxyFactory;

import com.devs4j.core.aop.proxies.advice.BeforeAdviceExample;

public class MazdaTest {

	@Test
	public void test_simpleCreation() {
		Mazda mazda = new Mazda();
		mazda.avanzar();
	}

	@Test
	public void test_usingProxies() {
		ProxyFactory factory=new ProxyFactory(new Mazda());
		factory.addInterface(Coche.class);
		factory.addAdvice(new BeforeAdviceExample());
		
		Coche coche =(Coche) factory.getProxy();
		coche.avanzar();
	}
}

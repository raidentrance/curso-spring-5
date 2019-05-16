/**
 * 
 */
package com.devs4j.core.aop.aspects;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.devs4j.core.aop.aspects.AspectCache;
import com.devs4j.core.aop.data.PersonComplexDao;
import com.devs4j.core.config.JacksonConfig;
import com.devs4j.core.config.JedisConfig;
import com.devs4j.spring.models.people.Person;

/**
 * @author maagapi
 *
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = { PersonComplexDao.class, AspectCache.class, JacksonConfig.class,
		JedisConfig.class, LoggerAspectExample.class })
@EnableAspectJAutoProxy
public class CacheExampleTest {

	@Autowired
	private PersonComplexDao dao;

	@Test
	public void testInjection() {
		assertNotNull(dao);
	}

	@Test
	public void simple_findByRfcTest() {
		Person person = dao.findByRfc("ARC283923");
		assertNotNull(person);
		assertEquals(person.getName(), "Arturo");
		assertEquals(person.getLastName(), "Catalan");
		assertEquals(person.getAge(), 32);
		Person person2 = dao.findByRfc("ARC283923");
		assertNotNull(person2);
		assertEquals(person2.getName(), "Arturo");
		assertEquals(person2.getLastName(), "Catalan");
		assertEquals(person2.getAge(), 32);

	}
}

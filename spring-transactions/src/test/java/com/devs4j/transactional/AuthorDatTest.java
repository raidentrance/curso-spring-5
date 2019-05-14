package com.devs4j.transactional;

import java.sql.SQLException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.devs4j.config.TestConfiguration;
import com.devs4j.spring.dao.AuthorDao;
import com.devs4j.spring.models.author.Author;

/**
 * 
 * @author raidentrance
 *
 */
/**
 * Indica que se utilizará un application context para todos los tests
 * SpringRunner es un alias para SpringJUnit4ClassRunner
 */
@RunWith(SpringJUnit4ClassRunner.class)
/**
 * Indica las classes a utilizar en este test unitario
 */
@ContextConfiguration(classes = { AuthorDao.class, TestConfiguration.class })
/**
 * Indica que todos los tests se deben ejecutar dentro de una transacción
 * es posible definirlo a nivel de método
 */
@Transactional
/**
 * Indica que el test se debe ejecutar bajo perfiles diferentes a prod
 *
 */
public class AuthorDatTest {
	@Autowired
	private AuthorDao authorDao;

	private static final Logger log = LoggerFactory.getLogger(AuthorDatTest.class);

	/**
	 * AuthorDao.create tiene un nivel de propagación mandatory así que debe
	 * ejecutarse dentro de una transacción, es por esto que debemos utilizar la
	 * anotación @Transactional
	 * 
	 * @throws SQLException
	 */
	@Test
	public void test() throws SQLException {
		log.info("Testing author dao under a transaction ");
		authorDao.create(new Author(100, "Juan", "@juanchopancho"));
	}
}

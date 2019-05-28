package com.devs4j.transactional;

import java.sql.SQLException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.IllegalTransactionStateException;

import com.devs4j.spring.dao.AuthorDao;
import com.devs4j.spring.models.author.Author;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = { AuthorDao.class})
@EnableAutoConfiguration
public class AuthorDaoTest2 {
	@Autowired
	private AuthorDao authorDao;
	
	
	private static final Logger log = LoggerFactory.getLogger(AuthorDaoTest2.class);

	/**
	 * 
	 * 
	 * @throws SQLException
	 */
	@Test(expected=IllegalTransactionStateException.class)
	public void test() throws SQLException {
		log.info("Testing author dao without a transaction ");
		authorDao.create(new Author(100, "Juan", "@juanchopancho"));
	}
}

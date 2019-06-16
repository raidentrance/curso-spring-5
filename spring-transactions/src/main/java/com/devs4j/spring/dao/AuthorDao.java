package com.devs4j.spring.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.devs4j.spring.models.author.Author;

/**
 * 
 * @author raidentrance
 *
 */
@Repository
public class AuthorDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	private static final Logger log = LoggerFactory.getLogger(AuthorDao.class);

	@PostConstruct
	public void init(){
		log.info("Initializing the author dao object");
	}

	public List<Author> findAll() {
		return jdbcTemplate.query("select * from author", new RowMapper<Author>() {
			@Override
			public Author mapRow(ResultSet rs, int arg1) throws SQLException {
				return new Author(rs.getInt("id"), rs.getString("name"), rs.getString("twitter"));
			}
		});
	}

//	@Transactional(noRollbackFor = DuplicateKeyException.class)
	@Transactional
	public void create(List<Author> authors) throws SQLException {
		for (Author author : authors) {
			jdbcTemplate.update("insert into author (id, name, twitter)values(?,?,?)", author.getId(), author.getName(),
					author.getTwitter());
		}
	}

	@Transactional(propagation = Propagation.MANDATORY)
	public void create(Author author) throws SQLException {
		jdbcTemplate.update("insert into author (id, name, twitter)values(?,?,?)", author.getId(), author.getName(),
				author.getTwitter());
	}
}

/**
 * 
 */
package com.devs4j.spring.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import com.devs4j.spring.models.author.Post;

/**
 * @author raidentrance
 *
 */
@Repository
public class PostDao {

	@Autowired
	private DataSource dataSource;

	@Autowired
	private PlatformTransactionManager transactionManager;

	@Autowired
	private TransactionTemplate transactionTemplate;

	private static final Logger log = LoggerFactory.getLogger(PostDao.class);

	public List<Post> findAll() throws SQLException {
		Connection con = dataSource.getConnection();
		PreparedStatement ps = con.prepareStatement("select * from post");
		ResultSet rs = ps.executeQuery();
		List<Post> result = new ArrayList<>();
		while (rs.next()) {
			Post post = toPost(rs);
			result.add(post);
		}
		return result;
	}

	public void create(Post post) throws SQLException {
		PreparedStatement ps = toPreparedStatement(post);
		ps.executeUpdate();
	}

	public void create(List<Post> posts) throws SQLException {
		Connection connection = dataSource.getConnection();
		connection.setAutoCommit(false);
		for (Post post : posts) {
			try {
				PreparedStatement ps = toPreparedStatement(post, connection);
				ps.executeUpdate();
			} catch (SQLException e) {
				log.info("Error creando los posts {}", e);
				connection.rollback();
			}
		}
		connection.commit();
	}

	public void createWithTransactionManager(List<Post> posts) throws SQLException {
		Connection connection = dataSource.getConnection();
		DefaultTransactionDefinition transactionDefinition = new DefaultTransactionDefinition();
		TransactionStatus status = transactionManager.getTransaction(transactionDefinition);
		for (Post post : posts) {
			try {
				PreparedStatement ps = toPreparedStatement(post, connection);
				ps.executeUpdate();
			} catch (SQLException e) {
				System.err.println(e);
				transactionManager.rollback(status);
			}
		}
		transactionManager.commit(status);
	}

	public void createWithTransactionTemplate(List<Post> posts) throws SQLException {
		transactionTemplate.execute(new TransactionCallbackWithoutResult() {
			@Override
			protected void doInTransactionWithoutResult(TransactionStatus status) {
				try {
					Connection connection = dataSource.getConnection();
					for (Post post : posts) {
						try {
							PreparedStatement ps = toPreparedStatement(post, connection);
							ps.executeUpdate();
						} catch (SQLException e) {
							System.err.println(e);
							throw new RuntimeException();
						}
					}
				} catch (SQLException e1) {
					System.err.println(e1);
				}
			}
		});
	}

	private PreparedStatement toPreparedStatement(Post post, Connection con) throws SQLException {
		PreparedStatement ps = con.prepareStatement("insert into post (id, name,content,author )values(?,?, ?,?)");
		ps.setInt(1, post.getId());
		ps.setString(2, post.getName());
		ps.setString(3, post.getContent());
		ps.setString(4, post.getAuthor());
		return ps;
	}

	private PreparedStatement toPreparedStatement(Post post) throws SQLException {
		Connection con = dataSource.getConnection();
		PreparedStatement ps = con.prepareStatement("insert into post (id, name,content,author )values(?,?, ?,?)");
		ps.setInt(1, post.getId());
		ps.setString(2, post.getName());
		ps.setString(3, post.getContent());
		ps.setString(4, post.getAuthor());
		return ps;
	}

	private Post toPost(ResultSet rs) throws SQLException {
		return new Post(rs.getInt("id"), rs.getString("name"), rs.getString("content"), rs.getString("author"));
	}
}

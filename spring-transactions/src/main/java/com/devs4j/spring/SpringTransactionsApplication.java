package com.devs4j.spring;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.devs4j.spring.dao.AuthorDao;
import com.devs4j.spring.dao.PostDao;
import com.devs4j.spring.models.author.Author;
import com.devs4j.spring.models.author.Post;
import com.devs4j.spring.services.AuthorService;

@SpringBootApplication
public class SpringTransactionsApplication {

	public static void print(List<Post> posts) {
		for (Post post : posts) {
			System.out.println(post);
		}
	}

	public static void developerTransactions(ConfigurableApplicationContext context) throws SQLException {
		PostDao dao = context.getBean(PostDao.class);
		/**
		 * Reads a list of posts
		 */
		print(dao.findAll());

		try {
			List<Post> posts = new ArrayList<>();
			posts.add(new Post(2, "Jpa", "Java Persistence api", "@raidentrance"));
			posts.add(new Post(3, "Hibernate", "Jboss hibernate", "@raidentrance"));
			posts.add(new Post(4, "Jsf", "Java serverFaces", "@raidentrance"));
//			posts.add(new Post(4, "Jsf", "Java serverFaces", "@raidentrance"));
			dao.createWithTransactionTemplate(posts);
		} catch (SQLException e) {
			System.err.println(e);
		} catch (RuntimeException e) {
			System.err.println(e);
		}
		print(dao.findAll());
	}

	public static void declarativeTransactions(ConfigurableApplicationContext context) {
		AuthorDao dao = context.getBean(AuthorDao.class);
		List<Author> authors = new ArrayList<>();
		authors.add(new Author(2, "Paco", "jfconavarrete"));
		authors.add(new Author(3, "Chino", "Holvater"));
		authors.add(new Author(3, "Chino", "Holvater"));
		try {
			dao.create(authors);
		} catch (Exception e) {
			System.err.println(e);
		}

		List<Author> result = dao.findAll();
		for (Author author : result) {
			System.out.println(author);
		}

	}

	public static void propagationLevels(ConfigurableApplicationContext context) throws SQLException {
		AuthorService postService = context.getBean(AuthorService.class);
		postService.create(1, "Paco", "jfconavarrete");
		List<Author> authors = postService.findAll();
		for (Author author : authors) {
			System.out.println(author);
		}
	}

	public static void main(String[] args) throws SQLException {
		ConfigurableApplicationContext context = SpringApplication.run(SpringTransactionsApplication.class, args);
//		 developerTransactions(context);
		 declarativeTransactions(context);
//		propagationLevels(context);
	}

}

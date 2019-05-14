/**
 * 
 */
package com.devs4j.mvc.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.devs4j.spring.models.author.Post;
import com.devs4j.spring.models.error.PostNotFoundException;

/**
 * @author raidentrance
 *
 */
@Service
public class PostService {
	private List<Post> posts = new ArrayList<>();

	@PostConstruct
	public void init() {
		posts.add(new Post(1, "Spring mvc", "This post is about spring mvc and how i like it ", "@raidentrance"));
		posts.add(new Post(2, "Spring jdbc", "This post is about spring jdbc and how i like it ", "@raidentrance"));
		posts.add(new Post(3, "Spring data", "This post is about spring data and how i like it ", "@raidentrance"));
		posts.add(new Post(4, "Spring rest", "This post is about spring rest and how i like it ", "@raidentrance"));
	}

	public List<Post> findAll() {
		return posts;
	}

	public void create(Post post) {
		posts.add(post);
	}

	public Optional<Post> findByName(String name) {
		return posts.stream().filter(p -> p.getName().equals(name)).findFirst();
	}

	public Optional<Post> findById(Integer id) {
		return posts.stream().filter(p -> p.getId().equals(id)).findFirst();
	}

	public void delete(String name) throws PostNotFoundException {
		Optional<Post> optional = findByName(name);
		if (optional.isPresent()) {
			posts.remove(optional.get());
		} else {
			throw new PostNotFoundException(String.format("Post %s couldn't be found in the system", name));
		}
	}
}

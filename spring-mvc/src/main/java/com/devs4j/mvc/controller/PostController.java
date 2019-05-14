/**
 * 
 */
package com.devs4j.mvc.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.devs4j.mvc.services.PostService;
import com.devs4j.spring.models.author.Post;
import com.devs4j.spring.models.error.PostNotFoundException;

/**
 * @author raidentrance
 *
 */
@Controller
public class PostController {
	@Autowired
	private PostService service;

	private List<Post> posts = new ArrayList<>();

	private static final Logger log = LoggerFactory.getLogger(PostController.class);

	@GetMapping("/posts")
	public String showPosts(Model model) {
		posts = service.findAll();
		model.addAttribute("posts", posts);
		return "posts";
	}

	@RequestMapping(value = "/posts", params = "create", method = RequestMethod.POST)
	public String create(@ModelAttribute Post post, Model model) {
		log.info("Creating post {}", post);
		service.create(post);
		model.addAttribute("posts", posts);
		return "posts";
	}

	@RequestMapping(value = "/posts", params = "delete", method = RequestMethod.POST)
	public String delete(@ModelAttribute("name") String name, Model model) {
		log.info("Deleting  post {}", name);
		try {
			service.delete(name);
		} catch (PostNotFoundException e) {
			model.addAttribute("error", e.getMessage());
		}
		model.addAttribute("posts", posts);
		return "posts";
	}

	@RequestMapping(value = "/posts/{id}", method = RequestMethod.GET)
	public String getById(@PathVariable("id") Integer id, Model model) {
		log.info("Get by id {}", id);
		Optional<Post> post = service.findById(id);
		if (post.isPresent()) {
			model.addAttribute("post", post.get());
		}
		model.addAttribute("error", String.format("Post %d not found ", id));
		return "post-by-id";
	}
}

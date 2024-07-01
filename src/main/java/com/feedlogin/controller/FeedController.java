package com.feedlogin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.feedlogin.entity.Post;
import com.feedlogin.entity.User;
import com.feedlogin.repository.PostRepository;
import com.feedlogin.repository.UserRepository;
import com.feedlogin.service.PostService;
import com.feedlogin.service.UserService;

@RestController
@RequestMapping("/feeds")
public class FeedController {
	 @Autowired
	    private PostService postService;

	    @Autowired
	    private UserService userService;

	    @GetMapping
	    public ResponseEntity<List<Post>> listFeeds() {
	        List<Post> posts = postService.findApprovedPosts();
	        return new ResponseEntity<>(posts, HttpStatus.OK);
	    }

	    @GetMapping("/my-posts")
	    public ResponseEntity<List<Post>> myPosts() {
	        String username = getUsername();
	        User user = (User) userService.findByUsername(username);
	        List<Post> posts = postService.findPostsByUser(user);
	        return new ResponseEntity<>(posts, HttpStatus.OK);
	    }

	    @PostMapping("/create")
	    public ResponseEntity<Void> createPost(@RequestParam String content) {
	        String username = getUsername();
	        User user = (User) userService.findByUsername(username);
	        Post post = new Post();
	        post.setContent(content);
	        post.setUser(user);
	        post.setApproved(false);  // Needs admin approval
	        postService.savePost(post);
	        return new ResponseEntity<>(HttpStatus.CREATED);
	    }

	    private String getUsername() {
	        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	        if (principal instanceof UserDetails) {
	            return ((UserDetails) principal).getUsername();
	        } else {
	            return principal.toString();
	        }
	    }
}

package com.feedlogin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.feedlogin.entity.Post;
import com.feedlogin.repository.PostRepository;

@RestController
@RequestMapping("/admin")
public class AdminController {

	  @Autowired
	   private PostRepository postRepository;
	  
	    @GetMapping("/posts")
	    public String listPosts(Model model) {
	        List<Post> posts = postRepository.findByApproved(false);
	        model.addAttribute("posts", posts);
	        return "admin-posts";
	    }


	    @PostMapping("/approve")
	    public String approvePost(@RequestParam Long postId) {
	        Post post = postRepository.findById(postId).orElseThrow();
	        post.setApproved(true);
	        postRepository.save(post);
	        return "redirect:/admin/posts";
	    }

	    @PostMapping("/delete")
	    public String deletePost(@RequestParam Long postId) {
	        postRepository.deleteById(postId);
	        return "redirect:/admin/posts";
	    }


}

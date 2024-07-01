package com.feedlogin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.feedlogin.entity.Post;
import com.feedlogin.entity.User;
import com.feedlogin.repository.PostRepository;
import com.feedlogin.repository.UserRepository;

@Service
public class UserService{
	private PostRepository postRepository;

	    @Autowired
	    private UserRepository userRepository;

	    public User findByUsername(String username) {
	        return userRepository.findByUsername(username);
	    }
}

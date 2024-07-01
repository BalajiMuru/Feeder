package com.feedlogin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.feedlogin.entity.Post;
import com.feedlogin.entity.User;
import com.feedlogin.repository.PostRepository;
@Service
public class PostService {
	@Autowired
    private PostRepository postRepository;

    public List<Post> findApprovedPosts() {
        return postRepository.findByApproved(true);
    }

    public List<Post> findPostsByUser(User user) {
        return postRepository.findByUser(user);
    }

    public void savePost(Post post) {
        postRepository.save(post);
    }


}

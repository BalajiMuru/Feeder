package com.feedlogin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.feedlogin.entity.Post;
import com.feedlogin.entity.User;

public interface PostRepository extends JpaRepository<Post,Long>{
	
//	List<Post> findByApproved(boolean approved);
//    List<Post> findByUser(String user);
  
    List<Post> findByApproved(boolean approved);
    List<Post> findByUser(User user);

}

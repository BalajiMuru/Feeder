package com.feedlogin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.feedlogin.entity.User;

public interface UserRepository  extends JpaRepository<User, Long>{

	 User findByUsername(String username);

}


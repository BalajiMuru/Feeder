package com.feedlogin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
	 @GetMapping("/login")
	    public String login() {
	        return "login";
	    }

	    @GetMapping("/register")
	    public String register() {
	        return "register";
	    }

}

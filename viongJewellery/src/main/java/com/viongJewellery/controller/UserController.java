package com.viongJewellery.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.viongJewellery.dto.User;
import com.viongJewellery.service.UserService;

@RestController
public class UserController {
	
	
	@Autowired
	UserService userService;
	
	@GetMapping("/api/user")
	public User User( ) {
		
		User user = userService.getUser();

		return user;
	}
}

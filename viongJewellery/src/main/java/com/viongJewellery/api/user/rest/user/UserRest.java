package com.viongJewellery.api.user.rest.user;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.viongJewellery.domain.user.UserService;
import com.viongJewellery.domain.user.dto.User;

@RestController
public class UserRest {
	
	
	@Autowired
	UserService userService;
	
	@GetMapping("/api/user")
	public User User( ) {
		
		User user = userService.getUser("admin01");

		return user;
	}
}

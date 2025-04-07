package com.viongJewellery;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.viongJewellery.domain.user.UserDAO;
import com.viongJewellery.domain.user.UserService;
import com.viongJewellery.domain.user.dto.User;

@SpringBootTest
public class UserTest {

	@Autowired
	UserService service;
	
	
	@Autowired
	UserDAO dao;
	
	
	@Test
	void userSelectOne() {
		
		User user = service.getUser("");
		
		
		//UserEntity entity = dao.select();
		//System.out.println(user);
		
		
	}
}

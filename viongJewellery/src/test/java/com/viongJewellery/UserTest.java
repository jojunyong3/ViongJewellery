package com.viongJewellery;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.viongJewellery.dao.UserDAO;
import com.viongJewellery.dto.User;
import com.viongJewellery.service.UserService;

@SpringBootTest
public class UserTest {

	@Autowired
	UserService service;
	
	
	@Autowired
	UserDAO dao;
	
	
	@Test
	void userSelectOne() {
		
		User user = service.getUser();
		
		
		//UserEntity entity = dao.select();
		//System.out.println(user);
		
		
	}
}

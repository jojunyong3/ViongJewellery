package com.viongJewellery.domain.user;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.viongJewellery.domain.user.dto.User;

@Service 
public class UserService {
	
	@Autowired
	UserDAO dao;
	
	public User getUser(String name)
	{
		UserEntity entity = dao.select(name);
		
		User user = new User(entity);
		
		return user;
	}
	
	
	public List<User> getUserList()
	{
		List<User> list = new ArrayList();
		
		

		return list;
	}
}

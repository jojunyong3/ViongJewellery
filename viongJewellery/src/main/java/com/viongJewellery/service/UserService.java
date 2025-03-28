package com.viongJewellery.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.viongJewellery.dao.UserDAO;
import com.viongJewellery.dto.User;
import com.viongJewellery.entity.UserEntity;

@Service 
public class UserService {
	
	@Autowired
	UserDAO dao;
	
	public User getUser()
	{
		UserEntity entity = dao.select("admin01");
		
		User user = new User(entity);
		
		
		return user;
	}
	
	
	public List<User> getUserList()
	{
		List<User> list = new ArrayList();
		
		

		return list;
	}
}

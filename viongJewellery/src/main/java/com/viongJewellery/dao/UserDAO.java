package com.viongJewellery.dao;

import org.apache.ibatis.annotations.Mapper;

import com.viongJewellery.entity.UserEntity;

@Mapper
public interface UserDAO {
	
	public UserEntity select(String id);
	
}

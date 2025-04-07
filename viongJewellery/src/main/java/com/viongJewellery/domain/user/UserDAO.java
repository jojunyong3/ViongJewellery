package com.viongJewellery.domain.user;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDAO {
	
	public UserEntity select(String id);
	
	public List<UserEntity> selectList(String name);
}

package com.viongJewellery.dto;

import com.viongJewellery.entity.UserEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

	private String id;
	private String name;
	private String passWord;
	
	public User(UserEntity entity)
	{
		this.id = entity.getID();
		this.name = entity.getNAME();
		this.passWord = entity.getPASSWORD();
	}
	
	
}

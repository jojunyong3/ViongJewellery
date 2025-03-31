package com.viongJewellery.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.viongJewellery.entity.NoticeEntity;




@Mapper
public interface NoticeDAO {
	
	public List<NoticeEntity> select();
	
}

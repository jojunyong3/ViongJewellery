package com.viongJewellery.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.viongJewellery.entity.NoticeEntity;
import com.viongJewellery.entity.ProductEntity;




@Mapper
public interface NoticeDAO {
	
	List<NoticeEntity> select(String id);	
	
	
	
}

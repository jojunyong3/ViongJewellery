package com.viongJewellery.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.viongJewellery.entity.ProductEntity;



@Mapper
public interface ProductDAO {

	public List<ProductEntity> selectList(String name);
}

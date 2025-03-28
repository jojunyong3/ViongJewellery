package com.viongJewellery.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.viongJewellery.dao.ProductDAO;
import com.viongJewellery.entity.ProductEntity;



@Service
public class ProductService {
	
	@Autowired
	ProductDAO dao;
	
	
	public List<ProductEntity> getList(String name)
	{
		//현재는 데이터 가공하는것 없이 그대로 컨트롤러로 전달
		List<ProductEntity> list = dao.selectList(name);
		
		
		
		
		return list;

	}
	
	
	public PageInfo<ProductEntity> getPagedProducts(int page, int size,String name)
	{
		PageHelper.startPage(page, size);
		//현재는 데이터 가공하는것 없이 그대로 컨트롤러로 전달
		List<ProductEntity> list = dao.selectList(name);
		return new PageInfo<>(list);

	}

}

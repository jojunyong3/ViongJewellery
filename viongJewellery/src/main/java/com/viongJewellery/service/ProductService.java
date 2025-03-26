package com.viongJewellery.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.viongJewellery.dao.ProductDAO;
import com.viongJewellery.entity.ProductEntity;



@Service
public class ProductService {
	
	@Autowired
	ProductDAO dao;
	
	
	public List<ProductEntity> test(String name)
	{
		//현재는 데이터 가공하는것 없이 그대로 컨트롤러로 전달
		List<ProductEntity> list = dao.selectList(name);
		
		
		return list;

	}

}

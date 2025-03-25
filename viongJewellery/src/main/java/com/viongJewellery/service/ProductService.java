package com.viongJewellery.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.viongJewellery.DAO.ProductDAO;



@Service
public class ProductService {
	
	@Autowired
	ProductDAO dao;
	
	
	public String test()
	{
		
		List<String> list = dao.selectList("");
		
		
		return "";
		//어떤 DAO 쓸까?
		//DAO이용해 데이터 가져온다.
		// 가져온 데이터를 가공한다.
		//가공된 데이터를 컨트롤러에 돌려준다.
	}

}

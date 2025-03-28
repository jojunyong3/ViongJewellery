package com.viongJewellery.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.viongJewellery.entity.ProductEntity;
import com.viongJewellery.service.ProductService;

@RestController
@RequestMapping("/api/v1/public/product")
public class ProductController {

	
	@Autowired
	ProductService service;
	
	
	
	
	@GetMapping("/page")
    public PageInfo<ProductEntity> getPagedProducts(
    		@RequestParam String name,
	        @RequestParam(defaultValue = "1") int page,
	        @RequestParam(defaultValue = "10") int size
    ) {
		PageInfo<ProductEntity> list = service.getPagedProducts(page, size, name);
		
		return list;
       
    }
}

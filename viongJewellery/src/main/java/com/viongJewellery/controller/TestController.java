package com.viongJewellery.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.viongJewellery.entity.ProductEntity;
import com.viongJewellery.service.ProductService;




@RestController
@RequestMapping("/api/v1/public")
public class TestController {

	

    
	@GetMapping("/ajaxtest")
	public ProductEntity get()
	{
		ProductEntity product = new ProductEntity();
		product.setPRODUCT_PRICE(1500);
		product.setPRODUCT_NAME("황금반지");
		
		return product;
	}

}

package com.viongJewellery.api.user.rest.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.viongJewellery.domain.product.ProductEntity;
import com.viongJewellery.domain.product.ProductService;

@RestController
@RequestMapping("/api/v1/public/product")
public class ProductRest {

	
	@Autowired
	ProductService service;	
	
	@GetMapping("/")
    public List<ProductEntity> getProducts(
    		@RequestParam String name
    ) {
		List<ProductEntity> list = service.getList(name);
		
		return list;
       
    }
	
	
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

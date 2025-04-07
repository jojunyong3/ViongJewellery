package com.viongJewellery.api.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.viongJewellery.domain.product.ProductEntity;
import com.viongJewellery.domain.product.ProductService;

@Controller
public class MainContoller {

	@Autowired
	ProductService service;
	
	
	@GetMapping("/")
	public String MainView(Model model) {
		
		List<ProductEntity> list = service.getList(null);
		
		model.addAttribute("productList", list);
		
		return "index";
	}
}

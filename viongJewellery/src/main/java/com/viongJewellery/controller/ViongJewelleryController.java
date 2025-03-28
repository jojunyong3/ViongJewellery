package com.viongJewellery.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.viongJewellery.entity.ProductEntity;
import com.viongJewellery.service.ProductService;

@Controller
public class ViongJewelleryController {
	
	@Autowired
	ProductService service;
	
	
	@GetMapping("/")
	public String MainView(Model model) {
		
		List<ProductEntity> list = service.getList(null);
		
		model.addAttribute("productList", list);
		
		return "index";
	}
	
	
	@GetMapping("/viongJewellery")
	public String testView(Model model) {
		
		
		model.addAttribute("message", "Hello, ViongJewellery");
	
		return "viongJewellery";
	}
	
}

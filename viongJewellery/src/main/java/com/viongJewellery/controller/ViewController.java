package com.viongJewellery.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.viongJewellery.entity.ProductEntity;
import com.viongJewellery.service.ProductService;

@Controller
public class ViewController {
	
	@Autowired
	ProductService service;
	
	
	@GetMapping("/")
	public String MainView(Model model) {
		
		List<ProductEntity> list = service.getList(null);
		
		model.addAttribute("productList", list);
		
		return "index";
	}
	
	
	@GetMapping("/v1/public/view/viongJewellery")
	public String testView(Model model) {
		
		
		model.addAttribute("message", "Hello, ViongJewellery");
	
		return "viongJewellery";
	}
	
	@GetMapping("/v1/public/view/notice")
	public String noticeView(Model model) {
				
			
		return "pages/menu/notice/notice";
	}
	
	@GetMapping("/v1/public/view/notice/detail")
	public String noticeDetailView(Model model) {
				
			
		return "pages/menu/notice/noticeDetail";
	}
}

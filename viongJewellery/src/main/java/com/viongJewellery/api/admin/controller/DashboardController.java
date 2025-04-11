package com.viongJewellery.api.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.viongJewellery.domain.metal.MetalPriceService;
import com.viongJewellery.domain.product.ProductService;



@Controller
public class DashboardController {

	@Autowired
	ProductService service;


	@Autowired
	MetalPriceService metalPriceService;
	
	@GetMapping("/v1/admin")
	public String adminView(Model model) {
				
	
	model.addAttribute("priceList",metalPriceService.getTodayPriceComparisonList() );

	
	
	
	return "pages/admin/index";
	}
}

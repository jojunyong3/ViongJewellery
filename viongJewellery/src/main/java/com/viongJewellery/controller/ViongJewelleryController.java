package com.viongJewellery.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViongJewelleryController {
	
	
	@GetMapping("/")
	public String indexView(Model model) {
		model.addAttribute("message", "Hello, ViongJewellery");
	
		return "viongJewellery";
	}
	
	
	@GetMapping("/viongJewellery")
	public String testView(Model model) {
		model.addAttribute("message", "Hello, ViongJewellery");
	
		return "viongJewellery";
	}
	
}

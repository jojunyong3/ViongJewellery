package com.viongJewellery.api.user.controller.notice;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/v1/public/notice")
public class NoticeController {


	
	@GetMapping()
	public String noticeView(Model model) {
				
			
		return "pages/menu/notice/notice";
	}
	
	@GetMapping("/detail")
	public String noticeDetailView(Model model) {
				
			
		return "pages/menu/notice/noticeDetail";
	}
	
	
}

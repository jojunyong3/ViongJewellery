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
		//아이디에 해당하는 게시글 정보 서비스를 통해서 가져온다.
		
		//가지고온 게시글 정보를 프론트엔드로 돌려준다.
		
			
		return "pages/menu/notice/noticeDetail";
	}
	
	
}

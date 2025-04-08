package com.viongJewellery.api.user.controller.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageInfo;
import com.viongJewellery.domain.notice.NoticeEntity;
import com.viongJewellery.domain.notice.NoticeService;
import com.viongJewellery.domain.notice.dto.Notice;

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

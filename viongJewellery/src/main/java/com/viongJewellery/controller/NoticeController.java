package com.viongJewellery.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.viongJewellery.entity.NoticeEntity;
import com.viongJewellery.service.NoticeService;

@RestController
public class NoticeController {
	
	
	@Autowired
	NoticeService noticeService;
	
	@GetMapping("/api/v1/public/notice")
	public List<NoticeEntity>  getNoticeList( 
			@RequestParam String id
	) {
		
		
		List<NoticeEntity> list = noticeService.getNotice(id);
		

		return list;
	}
}

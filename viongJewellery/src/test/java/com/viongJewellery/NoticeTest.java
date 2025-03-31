package com.viongJewellery;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.viongJewellery.dao.UserDAO;
import com.viongJewellery.dto.User;
import com.viongJewellery.entity.NoticeEntity;
import com.viongJewellery.service.NoticeService;
import com.viongJewellery.service.UserService;

@SpringBootTest
public class NoticeTest {

	
	@Autowired
	NoticeService service;
	

	
	@Test
	void noticeTest() {
		
		List<NoticeEntity> list = service.getNotice();
		
		
		System.out.println(list.size());
		
		
	}
}

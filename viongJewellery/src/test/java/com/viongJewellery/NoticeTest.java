package com.viongJewellery;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.github.pagehelper.PageInfo;
import com.mysql.cj.protocol.x.Notice;
import com.viongJewellery.domain.notice.NoticeEntity;
import com.viongJewellery.domain.notice.NoticeService;

@SpringBootTest
public class NoticeTest {
	
	@Autowired
	NoticeService service;
	
	@Test
	void noticeSelectOne() {
		
		PageInfo<NoticeEntity> notice = service.getNoticePage(null, 1, 10);
		
		
		//UserEntity entity = dao.select();
		//System.out.println(user);
		
		
	}
}

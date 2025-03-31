package com.viongJewellery.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mysql.cj.protocol.x.Notice;
import com.viongJewellery.dao.NoticeDAO;
import com.viongJewellery.dto.User;
import com.viongJewellery.entity.NoticeEntity;

@Service 
public class NoticeService {
	
	@Autowired
	NoticeDAO dao;
	
	public List<NoticeEntity>  getNotice()
	{
		List<NoticeEntity> entity = dao.select();
		

		return entity;
	}
	
}

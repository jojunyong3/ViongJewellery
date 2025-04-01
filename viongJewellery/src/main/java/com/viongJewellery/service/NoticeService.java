package com.viongJewellery.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.viongJewellery.dao.NoticeDAO;
import com.viongJewellery.entity.NoticeEntity;

@Service 
public class NoticeService {
	
	@Autowired
	NoticeDAO dao;
	
	public List<NoticeEntity>  getNotice(String id)
	{
		
		List<NoticeEntity> entity = dao.select(id);
		
		return entity;
	}
	
	
}

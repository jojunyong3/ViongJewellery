package com.viongJewellery.domain.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.viongJewellery.domain.notice.dto.Notice;

@Service 
public class NoticeService {
	
	@Autowired
	NoticeDAO dao;	
	
	public List<NoticeEntity>  getNotice(String id)
	{
		
		List<NoticeEntity> entity = dao.select(id);
		
		return entity;
	}
	
	public PageInfo<NoticeEntity>  getNoticePage(String id, int size, int page)
	{
		PageHelper.startPage(page, size);
		
		List<NoticeEntity> entity = dao.select(id);

		return new PageInfo<>(entity);
	}
	
	public void insert(Notice notice) {
	
		NoticeEntity entity = new NoticeEntity();
		
		entity.setTITLE(notice.getTitle());
		entity.setCONTENT(notice.getContent());				
		
		dao.insert(entity);
		
		}
	
	public NoticeEntity getNoticeById(String id) {		
		
	    return dao.find(id);	           
	}
	
	public void deleteNotice(String id) {
		
        dao.delete(id);
    }
}

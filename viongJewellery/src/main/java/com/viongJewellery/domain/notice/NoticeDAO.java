package com.viongJewellery.domain.notice;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.viongJewellery.domain.notice.dto.Notice;
import com.viongJewellery.domain.product.ProductEntity;




@Mapper
public interface NoticeDAO {
	
	List<NoticeEntity> select(String id);	
	
	void insert(NoticeEntity notice);
	
	NoticeEntity find(@Param("id") String id);
	
	void delete(@Param("id") String id);
}

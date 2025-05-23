package com.viongJewellery.domain.notice.dto;

import com.viongJewellery.domain.notice.NoticeEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Notice {

	private String id;
	private String title;
	private String content;
	private String createdAt;
	
	public Notice(NoticeEntity entity)
	{
		this.id = entity.getID();
		this.title = entity.getTITLE();
		this.content = entity.getCONTENT();
		this.createdAt = entity.getCREATED_AT();
	}
	
	public void NoticeEntity(NoticeEntity entity) {
		entity.setTITLE(title);
		entity.setCONTENT(content);
	}
}

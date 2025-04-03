package com.viongJewellery.dto;

import com.viongJewellery.entity.NoticeEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Notice {

	private String ID;
	private String TITLE;
	private String CONTENT;
	private String CREATED_AT;
	
	public Notice(NoticeEntity entity)
	{
		this.ID = entity.getID();
		this.TITLE = entity.getTITLE();
		this.CONTENT = entity.getCONTENT();
		this.CREATED_AT = entity.getCREATED_AT();
	}
	
	
}

package com.viongJewellery.api.user.rest.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.viongJewellery.domain.notice.NoticeEntity;
import com.viongJewellery.domain.notice.NoticeService;
import com.viongJewellery.domain.notice.dto.Notice;

@RestController
@RequestMapping("api/v1/public/notice")
public class NoticeRest {

	@Autowired
	NoticeService noticeService;
	
	
	@GetMapping("/")
	public List<NoticeEntity>  getNoticeList( 
			@RequestParam String id
			
	) {
				
		List<NoticeEntity> list = noticeService.getNotice(id);
		
		return list;
	}
	
	@GetMapping("/page")
	public PageInfo<NoticeEntity>  getNoticePage( 
			@RequestParam String id,
			@RequestParam(defaultValue = "1") int page,
	        @RequestParam(defaultValue = "10") int size
	) {
				
		PageInfo<NoticeEntity> list = noticeService.getNoticePage(id ,size, page);
	
		return list;
	}
	
	 @GetMapping("/{title}")
	    public Notice get(@PathVariable String title) {
	
	        return new Notice("","","",title);
	    }
	
	@PostMapping()
	public String putNotice(@RequestBody Notice notice) {		
		
			
		System.out.println(notice.getTitle());
		System.out.println(notice.getContent());
		
		
		return "완료";
	}
}

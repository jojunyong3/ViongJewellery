package com.viongJewellery.api.user.rest.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
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
@RequestMapping("/api/v1/public/notice")
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
	
	
	@PostMapping()
	public ResponseEntity<Void> putNotice(@RequestBody Notice notice) {		
		
		noticeService.insert(notice);
		
		return ResponseEntity.status(HttpStatus.CREATED).build();  // 성공시 201 상태 코드 반환
	}
	
	@GetMapping("/{id}")
    public ResponseEntity<NoticeEntity> getNoticeById(@PathVariable("id") String id) {
		
        NoticeEntity notice = noticeService.getNoticeById(id);
        
        return ResponseEntity.ok(notice);
    }
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteNotice(@PathVariable("id") String id) {
	    noticeService.deleteNotice(id);
	    return ResponseEntity.noContent().build();  // 204 No Content
	}
}

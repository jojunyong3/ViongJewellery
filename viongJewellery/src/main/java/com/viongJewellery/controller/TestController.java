package com.viongJewellery.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.viongJewellery.dto.User;




@RestController
@RequestMapping("/api/v1/public/ajaxtest")
public class TestController {

		

    	/**
    	 * 리스트를 조회 한다. 쿼리파라미터 수신
    	 * @return
    	 */
	    @GetMapping("/list")
	    public List<User> getList(@RequestParam String name,@RequestParam String passWord) {
	    	
	    	List<User> list = new ArrayList();
	    	list.add(new User("1",name,passWord));
	    	list.add(new User("2",name,passWord));
	        return list;
	    }
	    
	    /**
	     * 단건 조회 패스파라미터 수신
	     * @return 객체 1개를 프론트로 전달.
	     */
	    @GetMapping("/{id}")
	    public User get(@PathVariable String id) {
	
	        return new User(id,"","");
	    }
	    	    
	    /**
	     * 
	     * @param user  바디파라미터를 받을때는 변수 1개로만 받을수 있다. 따라서 일치하는 객체를 받도록 해야 된다. 
	     *              name, password 따로 변수2개로 받는건 불가능하다.
	     * @return post 는 데이터 추가이기때문에 돌려줄 데이터가 없다. 따라서 요청에따른 결과 상태코드를 반환한다.
	     */
	    @PostMapping 
	    public ResponseEntity<Void> post(@RequestBody User user) {
	    	
	    	System.out.println(user.getName());
	    	System.out.println(user.getPassWord());
	    
	        return ResponseEntity.status(HttpStatus.CREATED).build();  // 성공시 201 상태 코드 반환
	    }
	    
	    

	    @PutMapping("/{id}")
	    public ResponseEntity<Void> put(@PathVariable String id, @RequestBody User user) {
	    	
	    	System.out.println(id);
	    	System.out.println(user.getName());
	    	System.out.println(user.getPassWord());
	    	return ResponseEntity.status(HttpStatus.NO_CONTENT).build();  // 성공시 204 상태 코드 반환
	    }

	    @PatchMapping("/{id}")
	    public ResponseEntity<Void> patch(@PathVariable String id, @RequestBody User user) {
	    	System.out.println(id);
	    	System.out.println(user.getName());
	    	System.out.println(user.getPassWord());
	    	return ResponseEntity.status(HttpStatus.NO_CONTENT).build();  // 성공시 204 상태 코드 반환
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> delete(@PathVariable String id) {
	    	System.out.println(id);
	    	
	    	return ResponseEntity.status(HttpStatus.NO_CONTENT).build();  // 성공시 204 상태 코드 반환
	    }

}

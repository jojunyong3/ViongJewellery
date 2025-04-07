package com.viongJewellery.api.admin.controller.test;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.AllArgsConstructor;
import lombok.Data;




@Data
@AllArgsConstructor
class Product{
	public String name;
	public int price;
}



@Controller
@RequestMapping("/v1/public")
public class TestController {
	
	
	//view 즉 html반환만이 목적이다. 데이터는 ajax요청으로 비동기로 따로 가져간다.
	@GetMapping("/test/paging")
	public String pagingTest(Model model)
	{
		return "test/paging";
	}
	
	/*
	 * 어드민 샘플 페이지
	 */
	@GetMapping("/test/infinitiscroll")
	public String infinitiScrollView(Model model)
	{
		return "test/infinitiscroll";
	}	
	
	
	/*
	 * 어드민 샘플 페이지
	 */
	@GetMapping("/test/admin")
	public String adminView(Model model)
	{
		return "test/admin";
	}	
	
	//view 즉 html반환만이 목적이다. 데이터는 ajax요청으로 비동기로 따로 가져간다.
	@GetMapping("/test/ajaxtest")
	public String AjaxTest(Model model)
	{
		return "test/ajaxtest";
	}
	
	@GetMapping("/test/thymeleaf")
	public String indexView(Model model) {
		
		//단일데이터 뷰에 전송
		model.addAttribute("message", "단일 테스트 데이터");
		//객체 뷰에 전송 (뷰에서 어떻게 받는지 확인!)
		model.addAttribute("obj",new Product("금",1500));
		
		//List<객체> 전송 뷰에서 타임리프로 어떻게 반복문 쓰는지 확인!
		List<Product> productList = new ArrayList();
		productList.add(new Product("금목걸이",1500));
		productList.add(new Product("은목걸이",200));
		productList.add(new Product("동목걸이",100));
		model.addAttribute("productList",productList);
		return "test/thymeleaf";
	}

	
}

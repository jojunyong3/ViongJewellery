package com.viongJewellery.api.admin.controller.price;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageInfo;
import com.viongJewellery.domain.metal.MetalPriceService;
import com.viongJewellery.domain.metal.dto.MetalPrice;
import com.viongJewellery.support.CodeCache;

import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/v1/admin/metal-prices")
public class MetalPriceController {

	
	private final MetalPriceService metalPriceService;
	
	private final CodeCache codecache;
	
	@GetMapping()
	public String metalPriceView(Model model) {
				
	return "pages/admin/metal-price/list";
	}
	
	@GetMapping("/create")
	public String metalPriceCreateView(Model model) {
				

		model.addAttribute("metalTypeList",codecache.getCodeListByType("MT001"));//금속타입 코드리스트 
		
	return "pages/admin/metal-price/detail";
	}
	
	@GetMapping("/{id}/edit")
	public String metalPriceEditView(@PathVariable String id,Model model ) {
				
	return "pages/admin/metal-price/detail";
	}
	
	

	@GetMapping("/fragment")
	public String getMetalPricesFragment(@RequestParam(defaultValue = "1") int page,
	                                     @RequestParam(defaultValue = "10") int size,
	                                     Model model) {
	    PageInfo<MetalPrice> prices = metalPriceService.getAllPaged(page, size);

	    // ✅ 컬럼 정보 (label은 표시 텍스트, field는 객체 필드명)
	    List<Map<String, String>> columns = List.of(
	        Map.of("label", "날짜", "field", "priceDate"),
	        Map.of("label", "이름", "field", "metalName"),
	        Map.of("label", "코드", "field", "metalType"),
	        Map.of("label", "공식가", "field", "officialPrice"),
	        Map.of("label", "매입가", "field", "buyPrice"),
	        Map.of("label", "판매가", "field", "sellPrice"),
	        Map.of("label", "단위", "field", "unit"),
	        Map.of("label", "데이터생성일", "field", "createdAt"),
	        Map.of("label", "데이터수정일", "field", "updatedAt")
	    );

	    model.addAttribute("columns", columns);
	    model.addAttribute("rows", prices.getList());
	    model.addAttribute("pageInfo", prices);
	    model.addAttribute("url", "/v1/admin/metal-prices/fragment");

	    return "fragments/paged-table :: paged-table";
	}

   

}

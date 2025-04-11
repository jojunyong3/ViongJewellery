package com.viongJewellery.api.admin.controller.price;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.viongJewellery.domain.metal.MetalPriceEntity;
import com.viongJewellery.domain.metal.MetalPriceService;
import com.viongJewellery.domain.metal.dto.MetalPrice;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class MetalPriceController {

	
	private final MetalPriceService metalPriceService;
	
	
	@GetMapping("/v1/admin/metal-prices")
	public String adminView(Model model) {
				
	return "pages/admin/metal-price/list";
	}
	
	@GetMapping("/v1/login")
	public void login(String id,String password)
	{
		

		
	}

   @GetMapping("/v1/admin/metal-prices/fragment")
    public String getFragment(@RequestParam(defaultValue = "1") int page,
                              @RequestParam(defaultValue = "10") int size,
                              Model model) {
    
	   
	   
	   
        PageInfo<MetalPrice> prices = metalPriceService.getAllPaged(page,size);
        
        
        
        
        model.addAttribute("pageInfo", prices);
        return "pages/admin/metal-price/price-table :: paged-table";
    }
   
   

}

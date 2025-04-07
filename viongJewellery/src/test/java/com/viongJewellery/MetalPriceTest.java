package com.viongJewellery;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.viongJewellery.domain.metal.MetalPriceService;
import com.viongJewellery.domain.metal.dto.MetalPrice;

@SpringBootTest
public class MetalPriceTest {

	@Autowired
	MetalPriceService service;
	
	@Test
	void toDayPriceTest() {
		
		MetalPrice price = service.getTodayPrice("MT00101");
		MetalPrice silverPrice = service.getTodayPrice("MT00102");
		
		System.out.println(price.getOfficialPrice());
		System.out.println(silverPrice.getOfficialPrice());
		//UserEntity entity = dao.select();
		//System.out.println(user);
		
		
	}
}

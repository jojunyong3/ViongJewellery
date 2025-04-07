package com.viongJewellery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import com.viongJewellery.api.admin.controller.test.TestController;

@SpringBootApplication()
public class ViongJewelleryApplication {

 

	public static void main(String[] args) {
		
		SpringApplication.run(ViongJewelleryApplication.class, args);
		
	}

}

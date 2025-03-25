package com.viongJewellery;

import com.viongJewellery.controller.TestController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication()
public class ViongJewelleryApplication {

 

	public static void main(String[] args) {
		
		SpringApplication.run(ViongJewelleryApplication.class, args);
		
	}

}

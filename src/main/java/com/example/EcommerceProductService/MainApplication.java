package com.example.EcommerceProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.EcommerceProductService.service.InitService;

@SpringBootApplication
public class MainApplication implements CommandLineRunner {

	@Autowired
	@Qualifier("initServiceImpl")
	private InitService initService;
	
	public static void main(String[] args) {
		SpringApplication.run(MainApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		if(!this.initService.initialize()) throw new Exception("Not able to initialize init service");
	}

}

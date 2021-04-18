package com.example.demo;

import com.alibaba.fastjson.JSON;
import com.example.demo.controller.ProductResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MybatisDemoApplication implements CommandLineRunner {
	@Autowired
	private ProductResource productResource;

	public static void main(String[] args) {
		SpringApplication.run(MybatisDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println(JSON.toJSONString(productResource.queryById("1")));
	}
}

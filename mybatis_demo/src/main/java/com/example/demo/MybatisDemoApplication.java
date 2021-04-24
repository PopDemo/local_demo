package com.example.demo;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.example.demo.controller.ProductResource;
import com.example.demo.dto.ProductDTO;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
@Slf4j
public class MybatisDemoApplication implements CommandLineRunner{
	@Autowired
	private ProductResource productResource;

	public static void main(String[] args) {
		SpringApplication.run(MybatisDemoApplication.class, args);
	}



	@Override
	public void run(String... args) throws Exception {
		//查询前进行定义page
		PageHelper.startPage(2,1);
		List<ProductDTO> productDTO = productResource.queryById("1");
		PageInfo<ProductDTO> page = new PageInfo<ProductDTO>(productDTO);
		log.info("page size:{}",page.getSize());
		log.info("page RowSet:{}", JSONObject.toJSONString(page.getList()));
	}



}

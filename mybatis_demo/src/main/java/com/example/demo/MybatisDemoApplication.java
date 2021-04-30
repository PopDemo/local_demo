package com.example.demo;

import com.example.demo.service.ProductMetasDataService;
import com.example.demo.vo.ProductMasterData;
import com.example.demo.controller.ProductResource;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@MapperScan("com.example.demo.service")
@SpringBootApplication
public class MybatisDemoApplication implements CommandLineRunner{
	@Autowired
	private ProductResource productResource;

	@Resource
	private ProductMetasDataService productMetasDataService;

	public static void main(String[] args) {
		SpringApplication.run(MybatisDemoApplication.class, args);
	}



	@Override
	public void run(String... args) throws Exception {
		//查询前进行定义page
		/*PageHelper.startPage(2,1);
		List<ProductDTO> productDTO = productResource.queryById("1");
		PageInfo<ProductDTO> page = new PageInfo<ProductDTO>(productDTO);
		log.info("page size:{}",page.getSize());
		log.info("page RowSet:{}", JSONObject.toJSONString(page.getList()));*/


		List<ProductMasterData> mesterDataList = productMetasDataService.quetyByALL();
		for(ProductMasterData productMasterData : mesterDataList){
			log.info("this Data:{}",productMasterData);
		}






	}



}

package com.example.demo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.ResourceUtils;

import java.io.*;


@SpringBootTest
class BufferedReaderFileDemoApplicationTests {

	@Test
	void contextLoads() throws Exception{

		//
//		Logger log = LoggerFactory.getLogger("Handle File LOGOUT");
//		String fileName = "classpath:log/result.log";
//		File file = ResourceUtils.getFile(fileName);
//		BufferedReader getFile = new BufferedReader(new FileReader(file));
		String thisLine = "";
//		while (null != (thisLine = getFile.readLine())){
//			JSONObject jsonObject  = JSONObject.parseObject(JSON.toJSONString(thisLine));
//			System.out.println(jsonObject.getString("coupon_name"));
//		}


		ClassPathResource classPathResource = new ClassPathResource("log/result.log");
		//io.字节流
		InputStream thisFile = classPathResource.getInputStream();

		BufferedReader br = new BufferedReader(new InputStreamReader(thisFile));
		int count = 0;
		while (null != (thisLine = br.readLine())){
			count++;
			JSONObject jsonObject  = JSONObject.parseObject(thisLine);
			System.out.println(jsonObject.getString("coupon_name"));
		}

		System.out.println("已处理了:"+count);







	}

}

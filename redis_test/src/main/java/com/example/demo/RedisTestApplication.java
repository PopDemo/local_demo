package com.example.demo;

import com.example.demo.config.RedisClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

@SpringBootApplication
@Slf4j
public class RedisTestApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(RedisTestApplication.class, args);
	}


	@Autowired
	private RedisClient redisClient;

	@Override
	public void run(String... args) throws Exception {

//		List<String> dataList = new ArrayList<>();
//		dataList.add("袜子");
//		dataList.add("帽子");
//		dataList.add("书本");
//		dataList.add("娃娃");
//		dataList.add("闹钟");
//		dataList.add("水杯");
//		dataList.add("笔记本");
//
//		for(String name : dataList){
//			redisClient.linkPop("total",name);
//			log.info("向指定队列:{}插入data为:{}","total",name);
//		}

		String topic= "total";

//		Scanner scan = new Scanner(System.in);
//		redisClient.linkPop(topic,scan.nextLine());
//		log.info("向指定队列:{}插入data为:{}",topic,scan.nextLine());

		for (Object data :  redisClient.lrange(topic,0,-1)){
			log.info("查询指定队列:{},data:{}",topic,data);
		}

		log.info("消费执行队列:{},消息为:{}",topic,redisClient.brpop(topic, 1L,TimeUnit.HOURS));















	}
}

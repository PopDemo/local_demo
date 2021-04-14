package cn.lazy.local.local_test;

import cn.lazy.local.local_test.cache.CacheService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
@SpringBootApplication
public class LocalTestApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(LocalTestApplication.class, args);
	}

	@Autowired private CacheService taskService;

	@Override
	public void run(String... args) throws Exception {
		ConcurrentHashMap cmap = taskService.geterpAppkey();
		log.info("获取appkey为:{}",cmap.get("erpAppKey"));
		Scanner scan = new Scanner(System.in);

		if (scan.nextLine().equals("get")){
			ConcurrentHashMap thiscmps = taskService.geterpAppkey();
			log.info("获取appkey为:{}",thiscmps.get("erpAppKey"));
		}

		if (scan.nextLine().equals("del")){
			taskService.delCacheErpAppkey();
		}

		if (scan.nextLine().equals("getsss")){
			ConcurrentHashMap thiscmps = taskService.geterpAppkey();
			log.info("获取appkey为:{}",thiscmps.get("erpAppKey"));
		}





	}
}

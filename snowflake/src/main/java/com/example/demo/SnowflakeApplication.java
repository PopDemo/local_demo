package com.example.demo;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
@Slf4j
public class SnowflakeApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SnowflakeApplication.class, args);
	}
	private static final String acsll = "{\"10\":\"a\",\"11\":\"A\",\"12\":\"b\",\"14\":\"B\",\"15\":\"c\",\"16\":\"C\",\"18\":\"d\",\"19\":\"D\",\"22\":\"e\",\"23\":\"E\",\"24\":\"f\",\"26\":\"F\",\"28\":\"g\",\"29\":\"G\",\"30\":\"h\",\"31\":\"H\",\"33\":\"i\",\"34\":\"I\",\"36\":\"j\",\"37\":\"J\",\"38\":\"k\",\"39\":\"K\",\"41\":\"l\",\"42\":\"L\",\"44\":\"m\",\"46\":\"M\",\"47\":\"n\",\"48\":\"N\",\"49\":\"o\",\"51\":\"O\",\"52\":\"p\",\"53\":\"P\",\"54\":\"q\",\"55\":\"Q\",\"56\":\"r\",\"57\":\"R\",\"58\":\"s\",\"78\":\"S\",\"60\":\"t\",\"61\":\"T\",\"62\":\"u\",\"63\":\"U\",\"64\":\"v\",\"65\":\"V\",\"66\":\"w\",\"67\":\"W\",\"68\":\"x\",\"69\":\"X\",\"70\":\"y\",\"71\":\"Y\",\"72\":\"z\",\"73\":\"Z\"}";
	private static final Map<String,String> ascllMap = JSON.parseObject(acsll, HashMap.class);
	@Override
	public void run(String... args) throws Exception {

		log.info(ascllMap.get("10"));


	}
}

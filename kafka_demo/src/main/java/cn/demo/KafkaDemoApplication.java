package cn.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.kafka.KafkaAutoConfiguration;



// TODO 1. 进行剔除SpringBoot集成Kakfa 本身的config;(防止自动配置使用)
@SpringBootApplication(exclude = {KafkaAutoConfiguration.class})
public class KafkaDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(KafkaDemoApplication.class, args);
	}

}

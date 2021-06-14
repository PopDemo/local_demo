package com.example.demo;


import com.example.demo.transaction.transactionExcuteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class SpringDemoApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringDemoApplication.class, args);
	}

	@Autowired private transactionExcuteService transactionExcuteService;


	@Override
	public void run(String... args) throws Exception{
		String memberId = transactionExcuteService.queryByMobile("15135061408");
		log.info("Query DB form mobile SUCCESS,ResonseData:{memberId:{},",memberId,"}");

	}
}

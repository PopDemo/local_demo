package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.apache.commons.codec.digest.DigestUtils;
import org.mybatis.spring.annotation.MapperScan;
import java.util.Scanner;

@SpringBootApplication
@MapperScan("com.example.demo")
public class ToMixMobileApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ToMixMobileApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Scanner sc = new Scanner(System.in);
		while (true){
			System.out.print("plase you,mobile: ");
			String mobile = sc.nextLine();
			String mix_phone = DigestUtils.md5Hex(DigestUtils.md5Hex("tmall" + mobile + "0JbX1Q").toLowerCase()).toLowerCase();
			System.out.println("minMoblie: "+mix_phone);
		}
	}
}

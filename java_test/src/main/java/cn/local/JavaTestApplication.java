package cn.local;

import cn.local.dto.ResponseSupportDTO;
import cn.local.dto.Tomcat;
import cn.local.support.ResponseExcuteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class JavaTestApplication implements CommandLineRunner {
	public static void main(String[] args) {
		SpringApplication.run(JavaTestApplication.class, args);
	}

	@Autowired private ResponseExcuteService responseExcuteService;
	@Override
	public void run(String... args) throws Exception {
		Tomcat tomcat = new Tomcat();
		tomcat.setAge("12");
		tomcat.setColor("red");
		tomcat.setName("Public");
		tomcat.setGender("女");

		log.info("run method success:{}",responseExcuteService.success(tomcat));



	}
}

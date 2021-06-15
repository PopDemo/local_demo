package cn.local.work;

import cn.local.work.service.ExcuteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;

@Slf4j
@SpringBootApplication
public class WorkDemoApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(WorkDemoApplication.class, args);
	}

	@Autowired private ExcuteService excuteService;


	@Override
	public void run(String... args) throws Exception {
		ByteArrayOutputStream byteArrayOutputStream = excuteService.excuteFile();
		log.info("file byte  -> {}",byteArrayOutputStream.size());


		String fileName = "C:\\Users\\MI\\Desktop\\out.xlsx";
		FileOutputStream fileOutputStream = new FileOutputStream(fileName);
		fileOutputStream.write(byteArrayOutputStream.toByteArray());
		fileOutputStream.flush();
		fileOutputStream.close();
	}
}

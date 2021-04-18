package com.example.demo;

import com.example.demo.getcsvsput.Handle;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;

@SpringBootApplication
@Slf4j
public class BufferedReaderFileDemoApplication implements CommandLineRunner {

	@Autowired private Handle handle;


	public static void main(String[] args) {
		SpringApplication.run(BufferedReaderFileDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		File file = new File("C:\\Users\\MI\\Desktop\\resource");
		File[] fileList = file.listFiles();
		for (File thisFile : fileList) {
			String fileName = thisFile.getName();
			//获取thisFile的绝对路径
			String absoluteFileName = thisFile.getAbsolutePath();

			if (fileName.contains("OUT")) continue;

			String outName = absoluteFileName.substring(0,absoluteFileName.length()-4)+"_OUT.csv";
			log.info("fileIn:{},fileOut:{}",absoluteFileName,outName);
			handle.outFileByInfo(absoluteFileName,outName);
			log.warn("处理完成!!!!!");
		}




	}
}

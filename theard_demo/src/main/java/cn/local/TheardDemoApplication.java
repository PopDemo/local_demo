package cn.local;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.concurrent.Callable;

@SpringBootApplication
public class TheardDemoApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(TheardDemoApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		new Runnable(){

			@Override
			public void run() {
				System.out.println("创建Runnable线程 run -> start");
			}
		};


		new Callable<String>(){

			@Override
			public String call() throws Exception {
				return null;
			}
		};






	}
}

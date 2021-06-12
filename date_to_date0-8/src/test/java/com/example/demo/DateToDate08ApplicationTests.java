package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

class DateToDate08ApplicationTests {
	private static DateTimeFormatter outputDtf = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
	private static DateTimeFormatter inputDtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	@Test
	void contextLoads() {
		ZonedDateTime scanTime = LocalDateTime.now()
				.atZone(ZoneId.systemDefault())
				.withZoneSameInstant(ZoneId.of("GMT"));
		String formattedScanTime = scanTime.format(outputDtf);
		System.out.println(formattedScanTime);


		dateTimeTo8("2020-01-21 16:00:00");

	}


	public static String dateTimeTo8(String date){
		ZonedDateTime scanTime = LocalDateTime.parse(date, inputDtf).atZone(ZoneId.systemDefault())
				.withZoneSameInstant(ZoneId.of("GMT"));
		String formattedScanTime = scanTime.format(outputDtf);
		System.out.println(formattedScanTime);

		return formattedScanTime;
	}

}

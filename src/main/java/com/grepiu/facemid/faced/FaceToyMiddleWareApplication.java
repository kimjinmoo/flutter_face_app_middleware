package com.grepiu.facemid.faced;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@SpringBootApplication
@Slf4j
@EnableScheduling
public class FaceToyMiddleWareApplication {

	public static void main(String[] args) {
		SpringApplication.run(FaceToyMiddleWareApplication.class, args);
	}

	/**
	 *
	 * 실시간으로 파일을 체크한다.
	 *
	 */
	@Scheduled(cron = "* * * * * *")
	public void check() {
		final String batchPath = "/service/results/" ;

		// 경로로 파일을 체크 후 API서버로 전달 한다.
		log.info("check...");
	}


}

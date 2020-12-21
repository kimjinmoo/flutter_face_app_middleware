package com.grepiu.facemid.faced;

import com.grepiu.facemid.faced.process.helpers.ExecuteRest;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@SpringBootApplication
@Slf4j
@EnableScheduling
public class FaceToyMiddleWareApplication {

	@Value("${grepiu.batch.patch}")
	String batchPath;

	public static void main(String[] args) {
		SpringApplication.run(FaceToyMiddleWareApplication.class, args);
	}

	/**
	 *
	 * 실시간으로 파일을 체크한다.
	 *
	 */
	@Scheduled(cron = "* * * * * *")
	public void check() throws Exception {
		File files = new File(batchPath);
		if(files.exists()) {
			for(String fileName : files.list()) {
				// read File
				String jsons = new String(Files.readAllBytes(Paths.get(batchPath+fileName)));

				// log
				log.info("file Name : {}", fileName);
				log.info("JSON : {}", jsons);

				// execute API Call
				ExecuteRest.request(jsons);

				// remove File
				File file = new File(batchPath+fileName);
				// 처리 후 파일은 삭제한다.
//				if(file.isFile()) file.delete();
			}
		} else {
			log.info("no files...");
		}
	}


}

package com.grepiu.facemid.faced.process.helpers;

import java.io.InputStream;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 쉘일 실행한다.
 */
@Component
@Slf4j
public class ExecuteShell {

  @Value("${grepiu.shell.path}")
  private String executeShell;

  /**
   * 쉘 스크립트를 실행한다.
   *
   * @param imageFilePath 이미지 경로
   */
  public void executeImageModule(String imageFilePath) throws Exception {
    log.info("execute : {}", executeShell + " " + imageFilePath);
    Process p = Runtime.getRuntime().exec(executeShell + " " + imageFilePath);
    InputStream is = p.getInputStream();
    int i = 0;
    while ((i = is.read()) != -1) {
      System.out.print((char) i);
    }
  }
}

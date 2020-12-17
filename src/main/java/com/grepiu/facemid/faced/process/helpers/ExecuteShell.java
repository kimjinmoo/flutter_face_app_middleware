package com.grepiu.facemid.faced.process.helpers;

import java.io.InputStream;

/**
 *
 * 쉘일 실행한다.
 *
 */
public class ExecuteShell {

  /**
   *
   * 쉘 스크립트를 실행한다.
   *
   * @param imageFilePath 이미지 경로
   */
  public static void executeImageModule(String imageFilePath) throws Exception {
    Process p = Runtime.getRuntime().exec("/json/test.bat");
    InputStream is = p.getInputStream();
    int i = 0;
    while( (i = is.read() ) != -1) {
      System.out.print((char)i);
    }
  }
}

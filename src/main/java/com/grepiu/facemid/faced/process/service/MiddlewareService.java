package com.grepiu.facemid.faced.process.service;

import com.grepiu.facemid.faced.process.helpers.ExecuteShell;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 *
 * 미들웨어 서비스
 *
 */
@Service
@AllArgsConstructor
public class MiddlewareService {

  private final ExecuteShell executeShell;

  /**
   *
   * 머신러닝을 실행한다.
   *
   * @param imageUrl 이미지 URL
   * @throws Exception
   */
  public void executeImage(String imageUrl) throws Exception {
    executeShell.executeImageModule(imageUrl);
  }
}

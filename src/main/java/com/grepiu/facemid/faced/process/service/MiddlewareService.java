package com.grepiu.facemid.faced.process.service;

import com.grepiu.facemid.faced.process.helpers.ExecuteShell;
import org.springframework.stereotype.Service;

/**
 *
 * 미들웨어 서비스
 *
 */
@Service
public class MiddlewareService {

  public void executeImage(String imageFilePath) {
    ExecuteShell.executeImageModule(imageFilePath);
  }
}

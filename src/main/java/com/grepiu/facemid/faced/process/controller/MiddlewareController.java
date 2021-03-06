package com.grepiu.facemid.faced.process.controller;

import com.grepiu.facemid.faced.process.service.MiddlewareService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 *
 *
 */
@RestController
@AllArgsConstructor
public class MiddlewareController {

  final MiddlewareService middlewareService;

  @PostMapping("/execute")
  public ResponseEntity<Object> executeShell(
      @RequestParam("uid") String uid,
      @RequestParam("imageUrl") String imageUrl
  ) throws Exception {
    // 이미지 분석을 실행한다.
    middlewareService.executeImage(uid, imageUrl);
    return ResponseEntity.ok("ok");
  }
}

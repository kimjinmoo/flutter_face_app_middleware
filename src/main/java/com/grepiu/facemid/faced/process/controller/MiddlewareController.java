package com.grepiu.facemid.faced.process.controller;

import com.grepiu.facemid.faced.process.service.MiddlewareService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

  @GetMapping("/execute/{imageUrl}")
  public ResponseEntity<Object> executeShell(
      @PathVariable("imageUrl") String imageUrl
  ) {
    // 이미지 분석을 실행한다.
    middlewareService.executeImage(imageUrl);
    return ResponseEntity.ok(null);
  }
}

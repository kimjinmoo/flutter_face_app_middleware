package com.grepiu.facemid.faced.process.helpers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

/**
 *
 * API 서버로 호출 한다.
 *
 */
@Component
public class ExecuteRest {

  @Value("${grepiu.server.callback}")
  String apiCallbackUrl;

  public void callback(String uid, String resultJson) {
    RestTemplate restTemplate = new RestTemplate();

    MultiValueMap<String, String> params = new LinkedMultiValueMap<>();

    params.add("uid", uid);
    params.add("resultJson", resultJson);

    ResponseEntity<String> result = restTemplate.postForEntity(apiCallbackUrl, params, String.class);
  }
}

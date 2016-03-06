package de.michlb.sample.web;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.Charset;

@RestController
public class SecureController {

  private RestTemplate restTemplate = new RestTemplate();

  @RequestMapping("/secure")
  public String loadSimpleAuth() {
    String url = "http://localhost:8081/simple";

    String plainCreds = "admin:admin";
    byte[] plainCredsBytes = plainCreds.getBytes();
    byte[] base64CredsBytes = Base64.encodeBase64(plainCredsBytes);
    String base64Creds = new String(base64CredsBytes);
    HttpHeaders headers = new HttpHeaders();
    headers.add("Authorization", "Basic " + base64Creds);

    HttpEntity<String> request = new HttpEntity<String>(headers);

    ResponseEntity<String> result = restTemplate.exchange(url, HttpMethod.GET, request, String.class);

    return result.getBody();
  }

}

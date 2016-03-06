package de.michlb.sample.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class SimpleController {

  private RestTemplate restTemplate = new RestTemplate();

  @RequestMapping("/")
  public String loadRestRoot () {
    String url = "http://localhost:8081";
    String result = restTemplate.getForObject(url, String.class);

    return result;
  }
}

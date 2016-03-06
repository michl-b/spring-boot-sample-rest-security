package de.michlb.sample.web;

import de.michlb.sample.service.MyRestFeignClient;
import de.michlb.sample.service.MyRestFeignClientSecure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class SimpleFeignController {

  @Autowired
  private MyRestFeignClient feignClient;

  @Autowired
  private MyRestFeignClientSecure feignClientSecure;

  @RequestMapping("/feign")
  public String loadRestFeignRoot () {
    String result = feignClient.getRootValue();

    return result;
  }

  @RequestMapping("/feignsecure")
  public String loadRestFeignSecure () {
    String result = feignClientSecure.getSecureValue();

    return result;
  }
}

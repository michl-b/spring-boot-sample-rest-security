package de.michlb.sample.service;


import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(url = "http://admin:admin@localhost:8081")
public interface MyRestFeignClientSecure {

  @RequestMapping(method = RequestMethod.GET, value = "/simple")
  String getSecureValue();

}

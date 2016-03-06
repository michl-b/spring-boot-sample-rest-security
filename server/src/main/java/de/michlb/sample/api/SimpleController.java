package de.michlb.sample.api;

import org.springframework.context.annotation.Role;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by mbart on 05.03.2016.
 */
@RestController
public class SimpleController {

  @RequestMapping("/simple")
  public String simpleRequest(){
    return "SECURE!";
  }

  @RequestMapping("/")
  public String homeRequest(){
    return "HaHa";
  }
}

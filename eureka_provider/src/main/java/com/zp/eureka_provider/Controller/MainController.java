package com.zp.eureka_provider.Controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 * @author zhaopeng
 * @create 2020-07-23 17:59
 */
@RestController
public class MainController {

    @Value("${server.port}")
    private  String PORT;

   @GetMapping("/getData")
   public String  getData() {
       return "hi , I am zp myport:"+PORT;
   }

}

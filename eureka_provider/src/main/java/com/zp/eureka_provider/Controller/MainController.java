package com.zp.eureka_provider.Controller;

import com.zp.eureka_provider.pojo.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

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

   @GetMapping("/getMap")
   public Map<String,String> getMap() {
       return Collections.singletonMap("id","123");
   }

   @GetMapping("/getUser")
   public User getUser() {
       User user=new User();
       user.setAge(11);
       user.setName("zzzz");
       return user;
   }

    @GetMapping("/getUser1")
    public User getUser(@RequestParam String name) {
        User user=new User();
        user.setAge(66);
        user.setName(name);
        return user;
    }

    @PostMapping("/saveUser")
    public User saveUser(@RequestParam("name") String name,@RequestParam("age")int age) {
        User user=new User();
        user.setName(name);
        user.setAge(age);
        System.err.println("user:"+user);
        return user;
    }

}

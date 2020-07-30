package com.zp.user_provider.controller;

import com.zp.user_api.UserApi;
import org.springframework.web.bind.annotation.*;

/**
 * @author zhaopeng
 * @create 2020-07-30 20:44
 */
@RestController("/user")
public class UserController implements UserApi {
    @Override
    @GetMapping("/alive")
    public String alive() {
        return "user_provider is running...";
    }

    @Override
    @GetMapping("/getById")
    public String getUserById(@RequestParam("id") Integer id) {
        return "user id = "+id;
    }
}

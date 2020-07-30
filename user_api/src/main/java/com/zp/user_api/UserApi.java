package com.zp.user_api;
import org.springframework.web.bind.annotation.*;

/**
 * 定义一列类接口
 * @author zhaopeng
 * @create 2020-07-30 21:31
 */
@RequestMapping("/user") //这个 "/User" 一定要写上，，不然consumer会出现路径重复映射的问题
public interface UserApi {
        @GetMapping("/alive")
        public String alive();

        @GetMapping("/getById")
        public String getUserById(@RequestParam("id") Integer id);
}

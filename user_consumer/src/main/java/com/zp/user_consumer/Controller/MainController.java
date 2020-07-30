package com.zp.user_consumer.Controller;
import com.zp.user_api.UserApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
/**
 * @author zhaopeng
 * @create 2020-07-30 20:46
 */
@RestController
public class MainController {
    @Autowired
    ConsumerApi api;
    @GetMapping("/alive")
    public String alive() {
        return api.alive();
    }

    @GetMapping("/getById")
    public String getById(@RequestParam("id") Integer id) {
        return api.getUserById(id); //方法名getUserById 要与上面的getById不一样才能执行成功
    }

}

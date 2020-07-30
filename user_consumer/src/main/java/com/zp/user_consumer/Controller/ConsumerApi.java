package com.zp.user_consumer.Controller;
import com.zp.user_api.UserApi;
import org.springframework.cloud.openfeign.FeignClient;
/**
 * fegin 接口
 * @author zhaopeng
 * @create 2020-07-30 20:48
 */
//@FeignClient(name = "oxx",url="http://localhost:81")
@FeignClient(name = "user-provider")
public interface ConsumerApi extends UserApi {
}

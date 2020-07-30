package com.zp.eureka_consumer;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
@SpringBootApplication
public class EurekaConsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(EurekaConsumerApplication.class, args);
    }
    @Bean
    //开启负载均衡
    @LoadBalanced
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    //定义随机的访问策略
    @Bean
    public IRule myRule() {
        return new RandomRule();
    }
}

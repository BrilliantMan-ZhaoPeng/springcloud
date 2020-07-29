package com.zp.eureka_consumer.controller;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import javax.annotation.Resource;
import java.util.List;
/**
 * @author zhaopeng
 * @create 2020-07-23 18:31
 */
@RestController
public class MainController {
    @Autowired
    DiscoveryClient client;

    @Resource
    EurekaClient eurekaClient;

    @Autowired
    LoadBalancerClient loadBalancerClient;

    @Autowired
    RestTemplate restTemplate;


    @GetMapping("/client")
    public String client() {
        List<String> services = client.getServices();
        System.err.println(services);
        return "client";
    }

    @GetMapping("/client2")
    public Object client2() {
        List<ServiceInstance> provider = client.getInstances("provider");
        System.err.println(provider);
        return provider;
    }

    @GetMapping("/client3")
    public Object client3() {
        //利用id查找
        //List<InstanceInfo> provider = eurekaClient.getInstancesById("LAPTOP-A69MHD9L:provider:80");
        //利用服务名
        List<InstanceInfo> provider = eurekaClient.getInstancesByVipAddress("provider", false);
        System.err.println(provider);
        if(provider.size() > 0) {
            InstanceInfo instanceInfo = provider.get(0);
            if (instanceInfo.getStatus() == InstanceInfo.InstanceStatus.UP) {
                String url = "http://" + instanceInfo.getHostName() + ":" + instanceInfo.getPort() + "/getData";
                System.err.println("url:" + url);
                RestTemplate restTemplate = new RestTemplate();
                String forObject = restTemplate.getForObject(url, String.class);
                System.err.println("getData:" + forObject);
                return forObject;
            }
        }
        return "oooooooooxxxx";
    }


    @GetMapping("/client4")
    public String client4() {
        //完成客户端的负载均衡，过滤掉死了的节点
        ServiceInstance provider = loadBalancerClient.choose("provider");
        String url="http://"+provider.getHost()+":"+provider.getPort()+"/getData";
        System.err.println("url:"+url);
        return restTemplate.getForObject(url,String.class);
    }


    @GetMapping("/client5")
    public String client5() {
        //完成客户端的负载均衡，过滤掉死了的节点
        //ServiceInstance provider = loadBalancerClient.choose("provider");
        //SString url="http://"+provider.getHost()+":"+provider.getPort()+"/getData";
        //自动处理Url
        String url="http://provider/getData";
        System.err.println("url:"+url);
        return restTemplate.getForObject(url,String.class);
    }
}

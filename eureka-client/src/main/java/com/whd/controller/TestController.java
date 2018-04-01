package com.whd.controller;

import com.whd.model.User;
import com.whd.service.UserService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class TestController {

    @Autowired
    private DiscoveryClient client;

    @Autowired
    private UserService userService;

    @Autowired
    private RestTemplate template;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Value("${queue-name}")
    private String queue;

    @RequestMapping("/getServer")
    public String getServer(){
        List<ServiceInstance> list = client.getInstances("user-service");
        String url = list.get(0).getUri().toString();
        return url;
    }

    @RequestMapping("/getUserById")
    public User getUserById(){
        //如果restTemplate加上注解 @loanbalance 调用接口只能用下面的方式调用了，如果没有加负载均衡就用上面的方法调用任务
        //return (User) template.getForObject("http://USER-SERVICE/getUserByIdAll",User.class);
        return userService.getUserById(1);
    }
    @RequestMapping("/addRabbitMq")
    public void addRabbitMq(){
        rabbitTemplate.convertAndSend(this.queue,"wanghuidong");
    }


}

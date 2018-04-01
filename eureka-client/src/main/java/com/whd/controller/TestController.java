package com.whd.controller;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    private EurekaClient client;

    @RequestMapping("/getServer")
    public String getServer(){
        InstanceInfo info = client.getNextServerFromEureka("eureka-client",false);
        return info.getIPAddr();
    }
}

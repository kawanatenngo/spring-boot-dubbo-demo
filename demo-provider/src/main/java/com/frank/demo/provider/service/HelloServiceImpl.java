package com.frank.demo.provider.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.frank.demo.HelloService;
import org.springframework.beans.factory.annotation.Value;

@Service(version = "${demo.service.version}")
public class HelloServiceImpl implements HelloService {

    @Value("${dubbo.application.name}")
    private String serviceName;

    @Override
    public String sayHello(String name) {
        return String.format("[%s] : Hello, %s", serviceName, name);
    }
}

package com.frank.demo.consumer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.frank.demo.HelloService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsumerController {

    @Reference(version = "${demo.service.version}")
    private HelloService helloService;

    @ApiOperation(value = "测试dubbo", notes = "输入任意字符串即可")
    @ApiImplicitParam(name = "name", value = "任意字符串", required = true, dataType = "String")
    @GetMapping("sayHello")
    public String sayHello(@RequestParam String name) {
        return helloService.sayHello(name);
    }

    public static void main(String[] args) {
        SpringApplication.run(ConsumerController.class);
    }

}

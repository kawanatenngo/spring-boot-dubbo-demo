package com.frank.demo.consumer.bootstrap;

import com.alibaba.dubbo.config.annotation.Reference;
import com.frank.demo.HelloService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;

@EnableAutoConfiguration
public class DubboConsumerBoostrap {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Reference(version = "${demo.service.version}")
    private HelloService helloService;

    public static void main(String[] args) {
        SpringApplication.run(DubboConsumerBoostrap.class).close();
    }

    @Bean
    public ApplicationRunner runner() {
        return args -> {
            logger.info(helloService.sayHello("frank"));
        };
    }
}

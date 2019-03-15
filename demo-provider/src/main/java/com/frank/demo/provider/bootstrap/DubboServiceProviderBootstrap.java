package com.frank.demo.provider.bootstrap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.core.env.Environment;

@EnableAutoConfiguration
public class DubboServiceProviderBootstrap {

    public static void main(String[] args) {
        new SpringApplicationBuilder(DubboServiceProviderBootstrap.class)
                .listeners((ApplicationListener<ApplicationEnvironmentPreparedEvent>) event -> {
                    Environment environment = event.getEnvironment();
                    int port = environment.getProperty("embedded.zookeeper.port", int.class);
                    new EmbeddedZooKeeper(port, false).start();
                }).run(args);
        // SpringApplication.run(DubboServiceProviderBootstrap.class);
    }
}

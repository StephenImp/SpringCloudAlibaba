package com.cn.democlient1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients(basePackages = "com.cn.democlient1.feign")
public class DemoClient1Application {

    public static void main(String[] args) {
        SpringApplication.run(DemoClient1Application.class, args);
    }

}

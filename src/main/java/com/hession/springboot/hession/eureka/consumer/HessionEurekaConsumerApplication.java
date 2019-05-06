package com.hession.springboot.hession.eureka.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient//等同@EnableDiscoveryClient
@EnableFeignClients//启用feign

public class HessionEurekaConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(HessionEurekaConsumerApplication.class, args);
    }

}

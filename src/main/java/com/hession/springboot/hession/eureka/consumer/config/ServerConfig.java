package com.hession.springboot.hession.eureka.consumer.config;


import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ServerConfig {

    @Bean("restTemplate")
    @LoadBalanced //不加该注解会报java.net.UnknownHostException异常
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}

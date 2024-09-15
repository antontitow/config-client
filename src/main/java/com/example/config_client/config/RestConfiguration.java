package com.example.config_client.config;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestConfiguration {

    @Bean
    @LoadBalanced
    @Qualifier("restTemplateLoadBalancer")
    @RefreshScope
    RestTemplate restTemplate(){
        return new RestTemplate();
    }
}

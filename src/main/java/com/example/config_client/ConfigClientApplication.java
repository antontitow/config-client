package com.example.config_client;

import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Lazy;

@SpringBootApplication
@EnableDiscoveryClient
public class ConfigClientApplication {

    @Autowired
    @Lazy
    EurekaClient eurekaClient;

    public static void main(String[] args) {
        SpringApplication.run(ConfigClientApplication.class, args);
    }

}

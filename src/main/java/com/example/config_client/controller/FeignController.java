package com.example.config_client.controller;

import com.example.config_client.config.ExampleConfiguration;
import com.example.config_client.feign.EurekaClientClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@Slf4j
@RequiredArgsConstructor
public class FeignController {

    private final EurekaClientClient client;

    @GetMapping("feign")
    String getService() {
        log.info("Feign");
        return client.getCardId();
    }
}

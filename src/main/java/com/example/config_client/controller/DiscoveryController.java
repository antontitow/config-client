package com.example.config_client.controller;

import com.example.config_client.config.ExampleConfiguration;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@Slf4j
@RequiredArgsConstructor
public class DiscoveryController {

    private final DiscoveryClient discoveryClient;
    private final ExampleConfiguration exampleConfiguration;

    @GetMapping("discovery")
    @CircuitBreaker(name = "discovery", fallbackMethod = "fallSending")
    String getService() {
        RestTemplate restTemplate = new RestTemplate();
        val instance = discoveryClient.getInstances(exampleConfiguration.getClientRest());
//        val instance = discoveryClient.getInstances("eureka-config-client-client");
        log.info("Discovery");
        log.info("Discovery");
        log.info(instance.toString());
        log.info(instance.get(0).getUri().toString()+ "/lastCard");
        return restTemplate.exchange(instance.get(0).getUri().toString()+ "/lastCard",
                HttpMethod.GET,
                null,
                String.class
                ).getBody();
    }

    public String fallSending(){
        log.info("load FALLL");
        return "dfdfdf";
    }
}

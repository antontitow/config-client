package com.example.config_client.controller;

import com.example.config_client.config.ExampleConfiguration;
import com.example.config_client.service.ClientSenderI;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@Slf4j
@RequiredArgsConstructor
public class DiscoveryLoadBalancerController {

    private final ExampleConfiguration exampleConfiguration;
    private final ClientSenderI sender;

    @CircuitBreaker(name = "discovery", fallbackMethod = "fallSending")
    @GetMapping("discovery/loadbalanced")
    String getService() {
        log.info("---Discovery loadbalancer---");
        log.info(exampleConfiguration.getClientRest() + "/lastCard");
return sender.sendRequest();
    }

    public String fallSending(){
        log.info("discovery load FALLL");
        return "dfdfdf";
    }
}

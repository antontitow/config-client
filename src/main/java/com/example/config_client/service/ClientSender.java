package com.example.config_client.service;

import com.example.config_client.config.ExampleConfiguration;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
@RequiredArgsConstructor
public class ClientSender implements ClientSenderI {
    private final ExampleConfiguration exampleConfiguration;
    private final @Qualifier("restTemplateLoadBalancer") RestTemplate restTemplate;

    @CircuitBreaker(name = "config-client", fallbackMethod = "fallSending")
    public String sendRequest(){
        return restTemplate.exchange("http://" +exampleConfiguration.getClientRest()+ "/lastCard",
                HttpMethod.GET,
                null,
                String.class
        ).getBody();
    }

    public String fallSending(){
    log.info("FALLL");
    return "dfdfdf";
    }
}

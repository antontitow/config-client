package com.example.config_client.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "eureka-config-client-client")
public interface EurekaClientClient {

    @GetMapping("/lastCard")
    String getCardId();

}

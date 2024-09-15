package com.example.config_client.controller;

import com.example.config_client.config.ExampleConfiguration;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class EntrypointController {
    private final ExampleConfiguration exampleConfiguration;

    @PostMapping("hi")
    String registration(@RequestBody String myName){
        return "Hi " + myName + exampleConfiguration.getExample();
    }
}

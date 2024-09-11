package com.example.config_client;

import com.example.config_client.config.ExampleConfiguration;
import com.example.config_client.config.NConfiguration;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class TestConfigServerConnection {

  private final ExampleConfiguration exampleConfiguration;
  private final NConfiguration nConfiguration;

  @PostConstruct
    public void showExample(){
      log.info("Profile, " + exampleConfiguration.getExample());
      log.info("Profile 2, " + nConfiguration.getWarn());
    }
}

package com.calisto.spring.rest_api.beans;

import com.calisto.spring.rest_api.communication.ApiDiskYandex.ControllerCommunication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

@org.springframework.context.annotation.Configuration
public class Configuration {

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    @Bean
    public ControllerCommunication controller(){
        return new ControllerCommunication();
    }
}

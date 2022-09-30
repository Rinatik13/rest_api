package com.calisto.spring.rest_api.communication.ApiDiskYandex;

import com.calisto.spring.rest_api.communication.ApiDiskYandex.entity.Link;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class GetUpLink {
    private final String URL = "https://cloud-api.yandex.net/v1/disk/resources/download?path=2.pdf";
    public Link getUrlUpFile(){
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders header = new HttpHeaders();
        header.add("Authorization","AQAAAAAPGEiVAADLW-o0sA3bOkg9j-CFcK4lxJA");
        HttpEntity<String> request = new HttpEntity<String>(header);
        ResponseEntity<Link> responseEntity =
                restTemplate.exchange(URL, HttpMethod.GET, request, new ParameterizedTypeReference<Link>() {
                });
        Link result = responseEntity.getBody();
        return result;
    }
}

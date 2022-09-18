package com.calisto.spring.rest_api.communication.ApiDiskYandex;

import com.calisto.spring.rest_api.communication.ApiDiskYandex.entity.Link;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class AddNewFolder {
    private String URL ; ;

    public Link addFolder(String nameFolder){
        URL = "https://cloud-api.yandex.net/v1/disk/resources?path=test/" + nameFolder;
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders header = new HttpHeaders();
        header.add("Authorization","");
        HttpEntity<String> request = new HttpEntity<String>(header);
        ResponseEntity<Link> responseEntity =
                restTemplate.exchange(URL, HttpMethod.PUT, request, new ParameterizedTypeReference<Link>() {
                });
        Link result = responseEntity.getBody();
        return result;

    }

}

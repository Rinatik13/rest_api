package com.calisto.spring.rest_api.communication;

import com.calisto.spring.rest_api.entity.Company;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class CompanyInfo {

    @Autowired
    RestTemplate restTemplate;

    public final String URL = "https://egrul.itsoft.ru/7730588444.json";

    public Company getCompanyInfo(String inn) throws ParseException, JsonProcessingException {

        String jsonText = restTemplate.getForObject(URL, String.class);
        Object obj = new JSONParser().parse(jsonText);
        JSONObject jo = (JSONObject) obj;
        String text = jo.toJSONString();
        System.out.println(text);

        return null;
    }
}


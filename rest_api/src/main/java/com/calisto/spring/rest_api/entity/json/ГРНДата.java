package com.calisto.spring.rest_api.entity.json;

import com.calisto.spring.rest_api.entity.json.Attributes;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ГРНДата {
    @JsonProperty("@attributes")
    public Attributes attributes;
}

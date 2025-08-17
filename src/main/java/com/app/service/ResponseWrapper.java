package com.app.service;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ResponseWrapper(@JsonProperty("result") String result, @JsonProperty("data") String data) {

}

package com.example.sfapp.service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.HashMap;
import java.util.Map;

@Service
public class SalesforceService {

    public Object getRules(String instanceUrl, String token) {

        WebClient client = WebClient.create();

        String query = "SELECT Id, Active, ErrorDisplayField, ErrorMessage " +
                "FROM ValidationRule";

        String uri = UriComponentsBuilder
                .fromHttpUrl(instanceUrl + "/services/data/v59.0/tooling/query/")
                .queryParam("q", query)
                .build(true)
                .toUriString();

        return client.get()
                .uri(uri)
                .header("Authorization", "Bearer " + token)
                .retrieve()
                .bodyToMono(Object.class)
                .block();
    }

    public Object toggleRule(String instanceUrl, String token, String id, boolean active) {

        WebClient client = WebClient.create();

        Map<String, Object> body = new HashMap<>();
        body.put("Active", active);

        return client.patch()
                .uri(instanceUrl + "/services/data/v59.0/tooling/sobjects/ValidationRule/" + id)
                .header("Authorization", "Bearer " + token)
                .bodyValue(body)
                .retrieve()
                .bodyToMono(Object.class)
                .block();
    }
}
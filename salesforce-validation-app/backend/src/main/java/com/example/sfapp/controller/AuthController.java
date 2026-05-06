package com.example.sfapp.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Value("${sf.client.id}")
    private String clientId;

    @Value("${sf.client.secret}")
    private String clientSecret;

    @Value("${sf.redirect.uri}")
    private String redirectUri;

    @Value("${sf.auth.url}")
    private String authUrl;

    // STEP 1: LOGIN URL GENERATOR
    @GetMapping("/login")
    public String login() {
        return authUrl +
                "/services/oauth2/authorize?response_type=code" +
                "&client_id=" + clientId +
                "&redirect_uri=" + redirectUri;
    }

    // STEP 2: CALLBACK HANDLER
    @GetMapping("/callback")
    public Map<String, Object> callback(@RequestParam String code) {

        WebClient client = WebClient.builder()
                .baseUrl(authUrl)
                .defaultHeader(HttpHeaders.CONTENT_TYPE,
                        MediaType.APPLICATION_FORM_URLENCODED_VALUE)
                .build();

        MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
        body.add("grant_type", "authorization_code");
        body.add("code", code);
        body.add("client_id", clientId);
        body.add("client_secret", clientSecret);
        body.add("redirect_uri", redirectUri);

        return client.post()
                .uri("/services/oauth2/token")
                .bodyValue(body)
                .retrieve()
                .bodyToMono(Map.class)
                .block();
    }
}
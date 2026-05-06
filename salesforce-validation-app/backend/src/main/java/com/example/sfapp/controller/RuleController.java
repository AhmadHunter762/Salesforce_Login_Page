package com.example.sfapp.controller;

import com.example.sfapp.service.SalesforceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rules")
public class RuleController {

    @Autowired
    private SalesforceService service;

    @GetMapping
    public ResponseEntity<?> getRules(
            @RequestParam String instanceUrl,
            @RequestHeader("Authorization") String token) {

        String accessToken = token.replace("Bearer ", "").trim();

        return ResponseEntity.ok(
                service.getRules(instanceUrl, accessToken)
        );
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> toggleRule(
            @PathVariable String id,
            @RequestParam boolean active,
            @RequestParam String instanceUrl,
            @RequestHeader("Authorization") String token) {

        String accessToken = token.replace("Bearer ", "").trim();

        return ResponseEntity.ok(
                service.toggleRule(instanceUrl, accessToken, id, active)
        );
    }
}
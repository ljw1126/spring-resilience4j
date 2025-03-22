package com.example.server1.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequiredArgsConstructor
public class MainController {
    private final RestTemplate restTemplate;

    @GetMapping("/")
    public String requestData() {
        assert restTemplate != null;
        return restTemplate.getForObject("/data", String.class);
    }
}

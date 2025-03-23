package com.example.server1.controller;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequiredArgsConstructor
public class MainController {
    private final RestTemplate restTemplate;

    @CircuitBreaker(name = "requestData", fallbackMethod = "fallbackTestMethod")
    @GetMapping("/")
    public String requestData() {
        assert restTemplate != null;
        return restTemplate.getForObject("/data", String.class);
    }

    private String fallbackTestMethod(Throwable throwable) {
        return throwable.getMessage();
    }
}

package com.example.server2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class DataController {

    @GetMapping("/data")
    public String requestData() {
        LocalDateTime now = LocalDateTime.now();

        try {
            Thread.sleep(10000); // 10s
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        return now.toString();
    }
}

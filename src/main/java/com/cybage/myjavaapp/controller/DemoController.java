package com.cybage.myjavaapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    @GetMapping("/")
    public String GetDemoMessage() {
        return "Hello, this is sample java microservice for Docker demo";
    }
}
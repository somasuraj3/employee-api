package com.cybage.myjavaapp.controller;

import com.cybage.myjavaapp.model.Message;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    @GetMapping("/")
    public ResponseEntity<Object> GetDemoMessage() {
        return new ResponseEntity<Object>(new Message("This message is from Java microservice"), HttpStatus.OK);
    }
}
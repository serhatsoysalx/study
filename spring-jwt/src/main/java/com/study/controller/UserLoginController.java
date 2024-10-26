package com.study.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class UserLoginController {

    @GetMapping
    public ResponseEntity<String> login() {
        return ResponseEntity.ok("gi");
    }
}

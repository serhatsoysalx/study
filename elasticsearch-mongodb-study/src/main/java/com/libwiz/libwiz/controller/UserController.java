package com.libwiz.libwiz.controller;

import com.libwiz.libwiz.entity.User;
import com.libwiz.libwiz.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/usersave")
    public ResponseEntity<User> userAdd(@RequestBody User user){
        return ResponseEntity.ok(userService.userAdd(user));
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUser(){
        return ResponseEntity.ok(userService.findAll());
    }
}

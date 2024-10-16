package com.study.controller;

import com.study.dto.UserDto;
import com.study.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<UserDto> userRegister(@RequestBody UserDto userDto){
        return ResponseEntity.ok(userService.userRegister(userDto));
    }

    @GetMapping("/existUser")
    public ResponseEntity<Boolean> existUser(@RequestBody UserDto userDto){
        return ResponseEntity.ok(userService.existUser(userDto));
    }

    @GetMapping("/getallusers")
    public ResponseEntity<List<UserDto>> getAllUser(){
        return ResponseEntity.ok(userService.getAllUser());
    }

    @GetMapping("/getuser")
    public ResponseEntity<UserDto> getUser(@RequestBody UserDto userDto){
        return ResponseEntity.ok(userService.findingAUserByUsername(userDto));
    }

}

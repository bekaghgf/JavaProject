package com.example.bootcamp_project.controller;

import com.example.bootcamp_project.dto.UserRequest;
import com.example.bootcamp_project.dto.UserResponse;
import com.example.bootcamp_project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public UserResponse createUser(@RequestBody UserRequest userRequest, @RequestParam("image") MultipartFile image) {
        return userService.createUser(userRequest, image);
    }

    @GetMapping("/all")
    public List<UserResponse> getAllUsers() {
        return userService.all();
    }

    @GetMapping("/{email}")
    public UserResponse getUserByEmail(@PathVariable String email) {
        return userService.getByEmail(email);
    }
}
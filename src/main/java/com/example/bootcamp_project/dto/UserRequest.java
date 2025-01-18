package com.example.bootcamp_project.dto;

import lombok.Data;

@Data
public class UserRequest {
    private String name;
    private String email;
    private String password;
}
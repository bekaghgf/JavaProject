package com.example.bootcamp_project.dto.auth;

import lombok.Data;

@Data
public class RegisterRequest {
    private String email;
    private String password;

}

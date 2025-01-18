package com.example.bootcamp_project.service;

import com.example.bootcamp_project.dto.auth.AuthResponse;
import com.example.bootcamp_project.dto.auth.LoginRequest;
import com.example.bootcamp_project.dto.auth.RegisterRequest;

public interface AuthService {
    AuthResponse register(RegisterRequest registerRequest);
    AuthResponse login(LoginRequest loginRequest);

}

package com.example.bootcamp_project.mapper;

import com.example.bootcamp_project.dto.auth.AuthResponse;
import com.example.bootcamp_project.dto.auth.RegisterRequest;
import com.example.bootcamp_project.model.User;
import org.springframework.stereotype.Component;

@Component
public interface AuthMapper {
    User toUser(RegisterRequest request);
    AuthResponse toResponse(String token);
}

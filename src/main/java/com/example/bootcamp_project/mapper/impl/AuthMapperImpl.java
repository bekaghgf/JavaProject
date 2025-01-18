package com.example.bootcamp_project.mapper.impl;

import com. example. bootcamp_project. mapper.Role;
import com.example.bootcamp_project.dto.auth.AuthResponse;
import com.example.bootcamp_project.dto.auth.RegisterRequest;
import com.example.bootcamp_project.mapper.AuthMapper;
import com.example.bootcamp_project.mapper.Role;
import com.example.bootcamp_project.model.User;

import org.springframework.stereotype.Component;

@Component
public class AuthMapperImpl  implements AuthMapper {

    @Override
    public User toUser(RegisterRequest request) {
        User user = new User();
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        user.setRole(Role.USER);
        return user;
    }

    @Override
    public AuthResponse toResponse(String token) {
       AuthResponse authResponse = new AuthResponse();
       authResponse.setToken(token);
       return authResponse;
    }
}

package com.example.bootcamp_project.mapper.impl;

import com.example.bootcamp_project.dto.UserRequest;
import com.example.bootcamp_project.dto.UserResponse;
import com.example.bootcamp_project.model.User;
import com.example.bootcamp_project.mapper.UserMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public User toUser(UserRequest request) {
        User user = new User();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword()); // Пароль должен быть закодирован
        return user;
    }

    @Override
    public UserResponse toResponse(User user) {
        UserResponse response = new UserResponse();
        response.setId(user.getId());
        response.setName(user.getName());
        response.setEmail(user.getEmail());
        // Добавьте другие поля, если необходимо
        return response;
    }

    @Override
    public List<UserResponse> toResponses(List<User> users) {
        return users.stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }
}
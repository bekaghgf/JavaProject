package com.example.bootcamp_project.mapper;

import com.example.bootcamp_project.dto.UserRequest;
import com.example.bootcamp_project.dto.UserResponse;
import com.example.bootcamp_project.model.User;

import java.util.List;

public interface UserMapper {
    User toUser(UserRequest request);
    UserResponse toResponse(User user);
    List<UserResponse> toResponses(List<User> users);
}
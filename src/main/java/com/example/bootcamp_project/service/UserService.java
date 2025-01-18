package com.example.bootcamp_project.service;

import com.example.bootcamp_project.dto.UserRequest;
import com.example.bootcamp_project.dto.UserResponse;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface UserService  {
    UserResponse createUser(UserRequest userRequest, MultipartFile image);
    List<UserResponse> all();
    UserResponse getByEmail(String email);

}

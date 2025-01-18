package com.example.bootcamp_project.service.impl;

import com.example.bootcamp_project.dto.UserRequest;
import com.example.bootcamp_project.dto.UserResponse;
import com.example.bootcamp_project.mapper.UserMapper;
import com.example.bootcamp_project.model.User;
import com.example.bootcamp_project.repository.UserRepository;
import com.example.bootcamp_project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public UserResponse createUser(UserRequest userRequest, MultipartFile image) {
        // Преобразуем UserRequest в сущность User
        User user = userMapper.toUser(userRequest);

        // Здесь можно добавить логику для обработки изображения (например, сохранение в S3)
        // Пример:
        // String imageUrl = storageService.uploadImage(image);
        // user.setImageUrl(imageUrl);

        // Сохраняем пользователя в базе данных
        User savedUser = userRepository.save(user);

        // Преобразуем сохраненного пользователя в UserResponse
        return userMapper.toResponse(savedUser);
    }

    @Override
    public List<UserResponse> all() {
        // Получаем всех пользователей из базы данных
        List<User> users = userRepository.findAll();

        // Преобразуем список пользователей в список UserResponse
        return users.stream()
                .map(userMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public UserResponse getByEmail(String email) {
        // Находим пользователя по email
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found with email: " + email));

        // Преобразуем пользователя в UserResponse
        return userMapper.toResponse(user);
    }
}
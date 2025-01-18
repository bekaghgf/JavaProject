package com.example.bootcamp_project.service.impl;


import com.example.bootcamp_project.dto.auth.AuthResponse;
import com.example.bootcamp_project.dto.auth.LoginRequest;
import com.example.bootcamp_project.dto.auth.RegisterRequest;
import com.example.bootcamp_project.exception.CustomException;
import com.example.bootcamp_project.mapper.AuthMapper;
import com.example.bootcamp_project.model.User;
import com.example.bootcamp_project.repository.UserRepository;
import com.example.bootcamp_project.service.AuthService;
import com.example.bootcamp_project.config.JwtService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final AuthMapper authMapper;

    @Override
    public AuthResponse register (RegisterRequest registerRequest){
        registerRequest.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
        User user = authMapper.toUser(registerRequest);
        user = userRepository.save(user);
        String token = jwtService.generateToken(user);
        return authMapper.toResponse(token);
    }
    @Override
    public AuthResponse login (LoginRequest loginRequest){
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getEmail(),
                        loginRequest.getPassword())
                );
        User user = userRepository.findByEmail(loginRequest.getEmail()).orElseThrow(()-> new CustomException("User not found", HttpStatus.BAD_REQUEST));
        String token = jwtService.generateToken(user);
        return authMapper.toResponse(token);
    }




}

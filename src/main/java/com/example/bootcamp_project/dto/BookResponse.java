package com.example.bootcamp_project.dto;

import lombok.Data;

@Data
public class BookResponse {
    private Long id;
    private String title;
    private String author;
    private String coverImageUrl;

    // Getters and Setters
}
package com.example.bootcamp_project.dto;

import lombok.Data;

import java.time.LocalDate;

@Data

public class BorrowedBooksResponse {
    private Long id;
    private Long userId;
    private Long bookId;
    private LocalDate borrowedDate;
    private LocalDate returnDate;

    // Getters and Setters
}
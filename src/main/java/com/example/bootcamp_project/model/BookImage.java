package com.example.bootcamp_project.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class BookImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String imageName;
    private String imageUrl;

    @OneToOne(mappedBy = "coverImage")
    private Book book;

    // Getters and Setters
}
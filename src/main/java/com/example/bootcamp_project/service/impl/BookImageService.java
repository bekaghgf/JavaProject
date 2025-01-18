package com.example.bootcamp_project.service.impl;

import com.example.bootcamp_project.model.BookImage;
import com.example.bootcamp_project.repository.BookImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookImageService {
    @Autowired
    private BookImageRepository bookImageRepository;

    public BookImage saveImage(BookImage bookImage) {
        return bookImageRepository.save(bookImage);
    }
}
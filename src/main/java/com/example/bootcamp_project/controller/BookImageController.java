package com.example.bootcamp_project.controller;

import com.example.bootcamp_project.model.BookImage;
import com.example.bootcamp_project.service.impl.BookImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/books")
public class BookImageController {
    @Autowired
    private BookImageService bookImageService;

    @PostMapping("/{bookId}/upload-cover")
    public BookImage uploadCover(@PathVariable Long bookId, @RequestBody BookImage bookImage) {
        return bookImageService.saveImage(bookImage);
    }
}
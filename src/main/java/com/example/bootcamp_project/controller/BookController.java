package com.example.bootcamp_project.controller;

import com.example.bootcamp_project.dto.BookRequest;
import com.example.bootcamp_project.dto.BookResponse;
import com.example.bootcamp_project.mapper.BookMapper;
import com.example.bootcamp_project.model.Book;
import com.example.bootcamp_project.service.impl.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookService bookService;

    @PostMapping("/create")
    public BookResponse createBook(@RequestBody BookRequest bookRequest) {
        Book book = BookMapper.toEntity(bookRequest);
        Book savedBook = bookService.createBook(book);
        return BookMapper.toDTO(savedBook);
    }

    @GetMapping("/all")
    public List<BookResponse> getAllBooks() {
        return bookService.getAllBooks().stream()
                .map(BookMapper::toDTO)
                .collect(Collectors.toList());
    }
}
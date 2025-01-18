package com.example.bootcamp_project.controller;

import com.example.bootcamp_project.dto.BorrowedBooksRequest;
import com.example.bootcamp_project.dto.BorrowedBooksResponse;
import com.example.bootcamp_project.service.impl.BorrowedBooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/borrowed-books")
public class BorrowedBookController {
    @Autowired
    private BorrowedBooksService borrowedBooksService;

    @PostMapping("/borrow")
    public BorrowedBooksResponse borrowBook(@RequestBody BorrowedBooksRequest request) {
        return borrowedBooksService.borrowBook(request);
    }

    @GetMapping("/user/{userId}")
    public List<BorrowedBooksResponse> getBorrowedBooksByUser(@PathVariable Long userId) {
        return borrowedBooksService.getBorrowedBooksByUser(userId);
    }
}
package com.example.bootcamp_project.service.impl;

import com.example.bootcamp_project.dto.BorrowedBooksRequest;
import com.example.bootcamp_project.dto.BorrowedBooksResponse;
import com.example.bootcamp_project.exception.CustomException;
import com.example.bootcamp_project.mapper.BorrowedBooksMapper;
import com.example.bootcamp_project.model.BorrowedBooks;
import com.example.bootcamp_project.model.Book;
import com.example.bootcamp_project.model.User;
import com.example.bootcamp_project.repository.BorrowedBooksRepository;
import com.example.bootcamp_project.repository.BookRepository;
import com.example.bootcamp_project.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BorrowedBooksService {
    @Autowired
    private BorrowedBooksRepository borrowedBooksRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BookRepository bookRepository;

    public BorrowedBooksResponse borrowBook(BorrowedBooksRequest request) {
        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new CustomException("File is Empty",  HttpStatus.BAD_REQUEST));

        Book book = bookRepository.findById(request.getBookId())
                .orElseThrow(() -> new CustomException("File is Empty",  HttpStatus.BAD_REQUEST));

        BorrowedBooks borrowedBooks = BorrowedBooksMapper.toEntity(request);
        borrowedBooks.setUser(user);
        borrowedBooks.setBook(book);

        BorrowedBooks savedBorrowedBooks = borrowedBooksRepository.save(borrowedBooks);
        return BorrowedBooksMapper.toDTO(savedBorrowedBooks);
    }

    public List<BorrowedBooksResponse> getBorrowedBooksByUser(Long userId) {
        List<BorrowedBooks> borrowedBooks = borrowedBooksRepository.findByUserId(userId);
        return borrowedBooks.stream()
                .map(BorrowedBooksMapper::toDTO)
                .collect(Collectors.toList());
    }
}
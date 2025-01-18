package com.example.bootcamp_project.mapper;

import com.example.bootcamp_project.dto.BorrowedBooksRequest;
import com.example.bootcamp_project.dto.BorrowedBooksResponse;
import com.example.bootcamp_project.model.BorrowedBooks;

public class BorrowedBooksMapper {
    public static BorrowedBooks toEntity(BorrowedBooksRequest dto) {
        BorrowedBooks borrowedBooks = new BorrowedBooks();
        borrowedBooks.setBorrowedDate(dto.getBorrowedDate());
        borrowedBooks.setReturnDate(dto.getReturnDate());
        return borrowedBooks;
    }

    public static BorrowedBooksResponse toDTO(BorrowedBooks borrowedBooks) {
        BorrowedBooksResponse dto = new BorrowedBooksResponse();
        dto.setId(borrowedBooks.getId());
        dto.setUserId(borrowedBooks.getUser().getId());
        dto.setBookId(borrowedBooks.getBook().getId());
        dto.setBorrowedDate(borrowedBooks.getBorrowedDate());
        dto.setReturnDate(borrowedBooks.getReturnDate());
        return dto;
    }
}
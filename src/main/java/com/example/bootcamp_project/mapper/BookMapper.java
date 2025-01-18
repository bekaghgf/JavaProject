package com.example.bootcamp_project.mapper;

import com.example.bootcamp_project.dto.BookRequest;
import com.example.bootcamp_project.dto.BookResponse;
import com.example.bootcamp_project.model.Book;

public class BookMapper {
    public static Book toEntity(BookRequest dto) {
        Book book = new Book();
        book.setTitle(dto.getTitle());
        book.setAuthor(dto.getAuthor());
        return book;
    }

    public static BookResponse toDTO(Book book) {
        BookResponse dto = new BookResponse();
        dto.setId(book.getId());
        dto.setTitle(book.getTitle());
        dto.setAuthor(book.getAuthor());
        if (book.getCoverImage() != null) {
            dto.setCoverImageUrl(book.getCoverImage().getImageUrl());
        }
        return dto;
    }
}
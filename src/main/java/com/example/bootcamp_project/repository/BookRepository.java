package com.example.bootcamp_project.repository;

import com.example.bootcamp_project.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
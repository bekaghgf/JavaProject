package com.example.bootcamp_project.repository;

import com.example.bootcamp_project.model.BorrowedBooks;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BorrowedBooksRepository extends JpaRepository<BorrowedBooks, Long> {
    List<BorrowedBooks> findByUserId(Long userId);

}
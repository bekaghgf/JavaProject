package com.example.bootcamp_project.repository;

import com.example.bootcamp_project.model.BookImage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookImageRepository extends JpaRepository<BookImage, Long> {
}
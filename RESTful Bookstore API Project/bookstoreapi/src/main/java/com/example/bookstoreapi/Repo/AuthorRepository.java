package com.example.bookstoreapi.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.bookstoreapi.dto.Author;

public interface AuthorRepository extends JpaRepository<Author, Integer> {

}

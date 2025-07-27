package com.example.bookstoreapi.dao;

import com.example.bookstoreapi.Repo.AuthorRepository;
import com.example.bookstoreapi.dto.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public class AuthorDao {

    @Autowired
    private AuthorRepository authorRepository;

    public Author saveAuthor(Author author) {
        return authorRepository.save(author);
    }

    
    public Optional<Author> fetchAuthorById(int authorId) {
        return authorRepository.findById(authorId);
    }

    
    public Page<Author> fetchAllAuthors(Pageable pageable) {
        return authorRepository.findAll(pageable);
    }

    
    public void deleteAuthor(Author author) {
        authorRepository.delete(author);
    }
}

package com.example.bookstoreapi.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Repository;

import com.example.bookstoreapi.Repo.BookRepository;
import com.example.bookstoreapi.dto.Book;


@Repository
public class BookDao {
    @Autowired
    private BookRepository bookRepository;

    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    public Optional<Book> fetchBookById(int bookId) {
        return bookRepository.findById(bookId);
    }
    
    public Page<Book> findAll(Specification<Book> spec, Pageable pageable) {
        return bookRepository.findAll(spec, pageable);
    }

    public Page<Book> findAll(Pageable pageable) {
        return bookRepository.findAll(pageable);
    }
    
    public List<Book> fetchAllBooks() {
        return bookRepository.findAll();
    }

    public void deleteBook(Book book) {
        bookRepository.delete(book);
    }

    public Book updateBook(int oldBookId, Book newBook) {
        newBook.setId(oldBookId);
        return saveBook(newBook);
    }

}

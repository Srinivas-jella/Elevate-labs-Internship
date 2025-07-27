//fileName: BookService.java

package com.example.bookstoreapi.service;

import com.example.bookstoreapi.dao.BookDao;
import com.example.bookstoreapi.dto.Book;
import com.example.bookstoreapi.exception.BookNotFoundException;
import com.example.bookstoreapi.util.ResponseStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @Autowired
    private BookDao bookDao;

    public ResponseStructure<Book> saveBook(Book book) {
      
        ResponseStructure<Book> responseStructure = new ResponseStructure<>();
        responseStructure.setStatusCode(HttpStatus.CREATED.value());
        responseStructure.setMesssage("Book saved successfully");
        responseStructure.setData(bookDao.saveBook(book));
        return responseStructure;
    }

    public ResponseStructure<Book> fetchBookById(int bookId) {
        ResponseStructure<Book> responseStructure = new ResponseStructure<>();
        Book book = bookDao.fetchBookById(bookId).orElseThrow(BookNotFoundException::new);
        responseStructure.setStatusCode(HttpStatus.OK.value());
        responseStructure.setMesssage("Book found successfully");
        responseStructure.setData(book);
        return responseStructure;
    }
    

    public Page<Book> searchBooks(String title, String genre, Double minPrice, Pageable pageable) {
        Specification<Book> spec = com.example.bookstoreapi.util.BookSpecification.build(title, genre, minPrice);
        return bookDao.findAll(spec, pageable);
    }
    
    public ResponseStructure<Book> updateBook(int bookId, Book newBookData) {
       
        Book existingBook = bookDao.fetchBookById(bookId).orElseThrow(BookNotFoundException::new);

        if (newBookData.getTitle() != null) {
            existingBook.setTitle(newBookData.getTitle());
        }
        if (newBookData.getGenre() != null) {
            existingBook.setGenre(newBookData.getGenre());
        }
        if (newBookData.getPrice() > 0) {
            existingBook.setPrice(newBookData.getPrice());
        }

        ResponseStructure<Book> responseStructure = new ResponseStructure<>();
        responseStructure.setStatusCode(HttpStatus.OK.value());
        responseStructure.setMesssage("Book updated successfully");
        responseStructure.setData(bookDao.saveBook(existingBook));
        return responseStructure;
    }

    public boolean deleteBookById(int bookId) {
        
        return bookDao.fetchBookById(bookId).map(book -> {
            bookDao.deleteBook(book);
            return true;
        }).orElse(false);
    }
}
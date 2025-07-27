package com.example.bookstoreapi.service;

import com.example.bookstoreapi.dao.AuthorDao;
import com.example.bookstoreapi.dto.Author;
import com.example.bookstoreapi.exception.AuthorNotFoundException;
import com.example.bookstoreapi.util.ResponseStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {

    @Autowired
    private AuthorDao authorDao;

    public ResponseStructure<Author> saveAuthor(Author author) {
        ResponseStructure<Author> responseStructure = new ResponseStructure<>();
        responseStructure.setStatusCode(HttpStatus.CREATED.value());
        responseStructure.setMesssage("Author saved successfully.");
        responseStructure.setData(authorDao.saveAuthor(author));
        return responseStructure;
    }

    public ResponseStructure<Author> fetchAuthorById(int authorId) {
        ResponseStructure<Author> responseStructure = new ResponseStructure<>();
        Author author = authorDao.fetchAuthorById(authorId)
                .orElseThrow(() -> new AuthorNotFoundException("Author with id " + authorId + " not found"));

        responseStructure.setStatusCode(HttpStatus.OK.value());
        responseStructure.setMesssage("Author fetched successfully.");
        responseStructure.setData(author);
        return responseStructure;
    }

  
    public Page<Author> fetchAllAuthors(Pageable pageable) {
        return authorDao.fetchAllAuthors(pageable);
    }

    
    public ResponseStructure<Author> updateAuthor(int authorId, Author newAuthorData) {
        Author existingAuthor = authorDao.fetchAuthorById(authorId)
                .orElseThrow(() -> new AuthorNotFoundException("Author with id " + authorId + " not found"));

       
        if (newAuthorData.getName() != null) {
            existingAuthor.setName(newAuthorData.getName());
        }

        ResponseStructure<Author> responseStructure = new ResponseStructure<>();
        responseStructure.setStatusCode(HttpStatus.OK.value());
        responseStructure.setMesssage("Author updated successfully.");
        responseStructure.setData(authorDao.saveAuthor(existingAuthor));
        return responseStructure;
    }

   
    public boolean deleteAuthorById(int authorId) {
       
        return authorDao.fetchAuthorById(authorId).map(author -> {
            authorDao.deleteAuthor(author);
            return true; 
        }).orElse(false); 
    }
}

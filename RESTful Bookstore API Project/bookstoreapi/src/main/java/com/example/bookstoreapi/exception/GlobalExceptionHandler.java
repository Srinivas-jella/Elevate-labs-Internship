package com.example.bookstoreapi.exception;

import com.example.bookstoreapi.util.ResponseStructure;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class GlobalExceptionHandler {

   
    @ExceptionHandler(AuthorNotFoundException.class)
    public ResponseEntity<ResponseStructure<String>> handleAuthorNotFoundException(AuthorNotFoundException ex) {
        
       
        ResponseStructure<String> responseStructure = new ResponseStructure<>();
        responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
        responseStructure.setMesssage("Author Not Found");
        responseStructure.setData(ex.getMessage());

       
        return new ResponseEntity<>(responseStructure, HttpStatus.NOT_FOUND);
    }

   
    @ExceptionHandler(BookNotFoundException.class)
    public ResponseEntity<ResponseStructure<String>> handleBookNotFoundException(BookNotFoundException ex) {
        ResponseStructure<String> responseStructure = new ResponseStructure<>();
        responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
        responseStructure.setMesssage("Book Not Found");
        responseStructure.setData(ex.getMessage());
        return new ResponseEntity<>(responseStructure, HttpStatus.NOT_FOUND);
    }
}

package com.example.bookstoreapi.exception;

public class BookNotFoundException extends RuntimeException {
    
    private String message = "Book ID not found in the database";

    @Override
    public String getMessage() {
        return message;
    }
}

package com.example.bookstoreapi.exception;

public class AuthorNotFoundException extends RuntimeException {

    public AuthorNotFoundException() {
        super("Author not found in the database.");
    }

    public AuthorNotFoundException(String message) {
        super(message);
    }
}

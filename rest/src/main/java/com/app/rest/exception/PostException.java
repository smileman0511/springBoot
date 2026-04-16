package com.app.rest.exception;

public class PostException extends RuntimeException {
    public PostException() {;}
    public PostException(String message) {
        super(message);
    }
}

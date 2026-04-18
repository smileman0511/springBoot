package com.app.rest.exception;

import org.springframework.http.HttpStatus;

public class PostException extends RuntimeException {

    private HttpStatus status;
    public PostException(String message) {
        super(message);
        this.status = status;
    }
}
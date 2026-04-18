package com.app.rest.controller;

import com.app.rest.domain.dto.ApiResponseDTO;
import com.app.rest.exception.PostException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomExceptionController {

    // 분기처리
    @ExceptionHandler(PostException.class)
    public ResponseEntity<ApiResponseDTO> postException(PostException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ApiResponseDTO.of(e.getMessage()));
    }
}

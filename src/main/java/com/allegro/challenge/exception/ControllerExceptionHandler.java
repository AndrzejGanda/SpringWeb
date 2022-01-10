package com.allegro.challenge.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Objects;


@ControllerAdvice
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler {

    private final HttpHeaders header;

    public ControllerExceptionHandler() {
        HttpHeaders header = new HttpHeaders();
        header.setContentType(MediaType.APPLICATION_JSON);
        this.header = header;
    }

    @ExceptionHandler(value = { NullPointerException.class})
    protected ResponseEntity<Object> handleInternalException(Exception ex, WebRequest webRequest) {
        return handleExceptionInternal(ex, new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR), header, HttpStatus.INTERNAL_SERVER_ERROR, webRequest);
    }

    @ExceptionHandler(value = { HttpClientErrorException.class})
    protected ResponseEntity<Object> handleNoResultExceptionException(HttpClientErrorException ex, WebRequest webRequest) {
        return handleExceptionInternal(ex, new ErrorResponse(ex.getRawStatusCode(), ex.getStatusText()), header, Objects.requireNonNull(HttpStatus.resolve(ex.getRawStatusCode())), webRequest);
    }
}

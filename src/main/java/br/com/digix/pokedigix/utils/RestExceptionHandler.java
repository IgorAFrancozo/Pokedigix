package br.com.digix.pokedigix.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class RestExceptionHandler {
    
    @ExceptionHandler(value = {Exception.class})
    protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpStatus status, WebRequest request){
        return 
    }
}

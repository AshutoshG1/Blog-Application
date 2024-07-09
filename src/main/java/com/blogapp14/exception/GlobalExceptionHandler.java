package com.blogapp14.exception;

import com.blogapp14.payload.ErrorDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

//    @ExceptionHandler(ResourceNotFound.class)
//    public ResponseEntity<String> handleResourceNotFoundException(
//            ResourceNotFound e
//    ){
//        return new ResponseEntity<>(e.getMessage(), HttpStatus.OK);
//    }

    @ExceptionHandler(ResourceNotFound.class)
    public ResponseEntity<ErrorDetails> handleResourceNotFoundException(
            ResourceNotFound e, WebRequest webRequest
    ){
        ErrorDetails error = new ErrorDetails(new Date(), e.getMessage(), webRequest.getDescription(false));
        return new ResponseEntity<>(error, HttpStatus.OK);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> globalExceptionHandler(
            Exception e
    ){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.OK);
    }
}

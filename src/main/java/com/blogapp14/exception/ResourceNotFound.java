package com.blogapp14.exception;

public class ResourceNotFound extends RuntimeException{

    public ResourceNotFound(String message){
        super(message);
    }
}

package com.geekbrains.spring.web.exceptions;

public class AlreadyExistUserException extends RuntimeException{
        public AlreadyExistUserException(String message) {
            super(message);
        }

}

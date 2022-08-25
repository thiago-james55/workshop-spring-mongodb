package com.nelioalves.workshopmongo.services.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;

public class ObjectNotFoundException extends RuntimeException {

    public ObjectNotFoundException(String message) {
        super(message);
    }

}

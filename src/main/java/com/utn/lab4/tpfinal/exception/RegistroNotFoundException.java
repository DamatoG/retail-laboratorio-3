package com.utn.lab4.tpfinal.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class RegistroNotFoundException extends RuntimeException{
    public RegistroNotFoundException(String message) {
        super(message);
//        this.setStackTrace(new StackTraceElement[0]);
    }
}
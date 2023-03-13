package com.utn.lab4.tpfinal.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public class BadRequestException extends RuntimeException{
        public BadRequestException(String message) {
            super(message, null, false, false);
//
        }
    }


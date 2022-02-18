package com.example.demo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Mauricio tapia
 */

@ResponseStatus(value = HttpStatus.BAD_REQUEST,reason = " Error ")
public class InterestNotValidException extends RuntimeException{
    public InterestNotValidException(String message)
    {
        super(message);
    }
}
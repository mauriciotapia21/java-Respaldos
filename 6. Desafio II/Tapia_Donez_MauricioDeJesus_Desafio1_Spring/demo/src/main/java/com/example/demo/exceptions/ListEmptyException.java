package com.example.demo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Mauricio tapia
 */

@ResponseStatus(value = HttpStatus.BAD_REQUEST,reason = "La lista se encuentra vacia")
public class ListEmptyException extends RuntimeException {
    public ListEmptyException(String message)
    {
        super(message);
    }
}

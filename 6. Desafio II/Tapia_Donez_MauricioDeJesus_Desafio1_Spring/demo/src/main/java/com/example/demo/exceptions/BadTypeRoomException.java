package com.example.demo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
/**
 * @author Mauricio tapia
 */
@ResponseStatus(value = HttpStatus.BAD_REQUEST,reason = "El tipo de habitacion no coincide con el numero de personas")
public class BadTypeRoomException extends RuntimeException{
    public BadTypeRoomException(String message)
    {
        super(message);
    }
}

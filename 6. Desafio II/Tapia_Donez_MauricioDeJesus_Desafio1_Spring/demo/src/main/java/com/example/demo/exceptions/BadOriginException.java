package com.example.demo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
/**
 * @author Mauricio tapia
 */

@ResponseStatus(value = HttpStatus.BAD_REQUEST,reason = "El destino ingresado no existe")
public class BadOriginException extends RuntimeException {
    public BadOriginException(String message)
    {

        super(message);
    }
}

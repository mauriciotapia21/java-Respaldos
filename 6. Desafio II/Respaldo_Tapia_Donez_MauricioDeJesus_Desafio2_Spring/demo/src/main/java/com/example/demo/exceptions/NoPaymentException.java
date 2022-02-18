package com.example.demo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST,reason = "El tipo de pago solo se puede realizar por tarjeta")
public class NoPaymentException extends RuntimeException{
    public NoPaymentException(String message)
    {
        super(message);
    }
}

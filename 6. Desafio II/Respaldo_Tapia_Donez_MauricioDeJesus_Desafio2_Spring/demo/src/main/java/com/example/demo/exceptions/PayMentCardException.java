package com.example.demo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST,reason = "El Tipo de pago que hiciste fue con DEBITO por favor poner 1 en su couta de pago")
public class PayMentCardException extends RuntimeException{
    public PayMentCardException(String message)
    {
        super(message);
    }
}

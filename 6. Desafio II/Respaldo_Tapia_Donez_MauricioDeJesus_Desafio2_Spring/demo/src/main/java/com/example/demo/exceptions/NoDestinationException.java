package com.example.demo.exceptions;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(value = HttpStatus.BAD_REQUEST,reason = "El destino ingresado no existe")
public class NoDestinationException extends RuntimeException
{
    public NoDestinationException(String message)
    {
        super(message);
    }
}

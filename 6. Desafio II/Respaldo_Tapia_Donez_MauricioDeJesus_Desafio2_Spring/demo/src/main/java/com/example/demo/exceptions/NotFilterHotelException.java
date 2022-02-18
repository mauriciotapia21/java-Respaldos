package com.example.demo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST,reason = "El tipo de habitacion que usted ingreso para el hotel no existe y no procedio su registro")
public class NotFilterHotelException extends RuntimeException{
    public NotFilterHotelException(String message)
    {
        super(message);
    }
}

package com.example.demo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Mauricio tapia
 */

@ResponseStatus(value = HttpStatus.BAD_REQUEST,reason = "Alguna de las fechas la ingresaste mal, verifica que la fecha de ingreso sea menor a la de salida.")
public class BadDatePeriod extends RuntimeException{
    public BadDatePeriod(String message)
    {
        super(message);
    }
}

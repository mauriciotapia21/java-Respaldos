package com.example.demo.exceptions;

import com.example.demo.dto.ErrorDTO;
import com.example.demo.dto.ErrorsListDTO;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import org.springframework.core.convert.ConversionFailedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class ControllerAdviceExceptions
{
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<ErrorDTO> badDateFormat(ConversionFailedException bad)
    {
        ErrorDTO error =new ErrorDTO();
        error.setName("ERROR");
        error.setDescription("Formato de fecha debe ser dd/mm/aaaa");
        return new ResponseEntity<ErrorDTO>(error, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(InvalidFormatException.class)
    public ResponseEntity<ErrorDTO> notValueNumber()
    {
        ErrorDTO error =new ErrorDTO();
        error.setName("ERROR");
        error.setDescription("El formato debe ser un valor numerico.");
        return new ResponseEntity<ErrorDTO>(error, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    private ResponseEntity<ErrorsListDTO> handleValidationExcepcions(MethodArgumentNotValidException ex){
        List<String> errorList = new ArrayList<>();
        ex.getFieldErrors().forEach(error -> errorList.add(error.getDefaultMessage()));
        ErrorsListDTO errorDTO = new ErrorsListDTO(errorList);
        return new ResponseEntity<>(errorDTO, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(NoPaymentException.class)
    public ResponseEntity<ErrorDTO> NoPaymentException(NoPaymentException bad)
    {
        ErrorDTO error =new ErrorDTO();
        error.setName("ERROR");
        error.setDescription(bad.getMessage());
        return new ResponseEntity<ErrorDTO>(error, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(InterestNotValidException.class)
    public ResponseEntity<ErrorDTO> InterestNotValidException(InterestNotValidException bad)
    {
        ErrorDTO error =new ErrorDTO();
        error.setName("ERROR");
        error.setDescription(bad.getMessage());
        return new ResponseEntity<ErrorDTO>(error, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(PayMentCardException.class)
    public ResponseEntity<ErrorDTO> PayMentCardException(PayMentCardException bad)
    {
        ErrorDTO error =new ErrorDTO();
        error.setName("ERROR");
        error.setDescription(bad.getMessage());
        return new ResponseEntity<ErrorDTO>(error, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(BadTypeRoomException.class)
    public ResponseEntity<ErrorDTO> BadTypeRoomException(BadTypeRoomException bad)
    {
        ErrorDTO error =new ErrorDTO();
        error.setName("ERROR");
        error.setDescription(bad.getMessage());
        return new ResponseEntity<ErrorDTO>(error, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(BadDatePeriod.class)
    public ResponseEntity<ErrorDTO>  BadDatePeriod( BadDatePeriod bad)
    {
        ErrorDTO error =new ErrorDTO();
        error.setName("ERROR");
        error.setDescription(bad.getMessage());
        return new ResponseEntity<ErrorDTO>(error, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(NoDestinationException.class)
    public ResponseEntity<ErrorDTO>  NoDestinationException( NoDestinationException bad)
    {
        ErrorDTO error =new ErrorDTO();
        error.setName("ERROR");
        error.setDescription(bad.getMessage());
        return new ResponseEntity<ErrorDTO>(error, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(NotFilterHotelException.class)
    public ResponseEntity<ErrorDTO>  NotFilterHotelException(NotFilterHotelException bad)
    {
        ErrorDTO error =new ErrorDTO();
        error.setName("ERROR");
        error.setDescription(bad.getMessage());
        return new ResponseEntity<ErrorDTO>(error, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(BadOriginException.class)
    public ResponseEntity<ErrorDTO>  BadOriginException(BadOriginException bad)
    {
        ErrorDTO error =new ErrorDTO();
        error.setName("ERROR");
        error.setDescription(bad.getMessage());
        return new ResponseEntity<ErrorDTO>(error, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(ListEmptyException.class)
    public ResponseEntity<ErrorDTO>  ListEmptyExceptions(ListEmptyException bad)
    {
        ErrorDTO error =new ErrorDTO();
        error.setName("ERROR");
        error.setDescription(bad.getMessage());
        return new ResponseEntity<ErrorDTO>(error, HttpStatus.BAD_REQUEST);
    }
}

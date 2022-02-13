package com.example.demo.exception.Hotel;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ControllerAdviceExceptions extends ResponseEntityExceptionHandler {


    @ExceptionHandler(value
            = {com.example.demo.exception.DuplicatedEntryBlogException.class})
    protected ResponseEntity<Object> handleConflict(
            RuntimeException ex, WebRequest request) {
        String bodyOfResponse = "Existe un dato duplicado, por favor intente con un nuevo ID";
        return handleExceptionInternal(ex, bodyOfResponse,
                new HttpHeaders(), HttpStatus.CONFLICT, request);
    }

    @ExceptionHandler(value
            = {com.example.demo.exceptions.NotFoundEntradaBlogException.class})
    protected ResponseEntity<Object> handleConflict2(
            RuntimeException ex, WebRequest request) {
        String bodyOfResponse = "No se pudo encontrar el ID ingresado, por favor ingrese de nuevo los datos";
        return handleExceptionInternal(ex, bodyOfResponse,
                new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }

}

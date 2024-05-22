package it.epicode.eserciziomartedi.exception;


import org.springframework.boot.autoconfigure.integration.IntegrationProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

import it.epicode.eserciziomartedi.model.Error;
import org.springframework.boot.autoconfigure.integration.IntegrationProperties;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CentralizedExceptionHandling extends ResponseEntityExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<Object> AutoreNonTrovatoHandler(AutoreNonTrovatoException e) {
        Error error = new Error();

        error.setMessage(e.getMessage());
        error.setDataErrore(LocalDateTime.now());
        error.setStatoErrore(HttpStatus.NOT_FOUND);
        return  new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
}

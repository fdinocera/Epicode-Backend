package it.epicode.esercizio.exception;

import org.apache.coyote.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

import it.epicode.esercizio.model.Error;

@RestControllerAdvice
public class CentralizedExceptionHandling extends ResponseEntityExceptionHandler {

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<Object> badRequestHandler(BadRequestException e) {
        Error error = new Error();

        error.setMessage(e.getMessage());
        error.setDataErrore(LocalDateTime.now());
        error.setStatoErrore(HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(DispositivoNonTrovatoException.class)
    public ResponseEntity<Object> dispositivoNonTrovato(DispositivoNonTrovatoException e){
        Error error = new Error();

        error.setMessage("Dispositivo non trovato");
        error.setDataErrore(LocalDateTime.now());
        error.setStatoErrore(HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(DipendenteNonTrovatoException.class)
    public ResponseEntity<Object> dipendenteNonTrovato(DipendenteNonTrovatoException e){

        Error error = new Error();
        error.setMessage("Dipendente non trovato");
        error.setDataErrore(LocalDateTime.now());
        error.setStatoErrore(HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}

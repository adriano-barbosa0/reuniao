package com.api.reuniao.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice // Indica que esta classe é um componente global para tratamento de exceções em controllers
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class) // Lidando com a exceção ResourceNotFoundException
    public ResponseEntity<?> resouceNotFoundException(ResourceNotFoundException exception, WebRequest request) {
        // Criando detalhes de erro personalizados com a data, mensagem e descrição da requisição
        var errorDetails = new ErrorDetails(new Date(), exception.getMessage(), request.getDescription(false));
        // Retornando uma resposta com os detalhes do erro e o status NOT_FOUND
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class) // Lidando com exceções gerais do tipo Exception
    public ResponseEntity<?> globalExceptionHandler(Exception exception, WebRequest request) {
        // Criando detalhes de erro personalizados com a data, mensagem e descrição da requisição
        var errorDetails = new ErrorDetails(new Date(), exception.getMessage(), request.getDescription(false));
        // Retornando uma resposta com os detalhes do erro e o status INTERNAL_SERVER_ERROR
        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

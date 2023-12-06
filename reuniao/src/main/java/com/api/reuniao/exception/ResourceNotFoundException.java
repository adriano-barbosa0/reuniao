package com.api.reuniao.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND) // Define a resposta HTTP como NOT_FOUND (404) quando essa exceção é lançada
public class ResourceNotFoundException extends Exception {

    private static final long serialVersionUID = 1L; // Identificador único para a versão serializável da classe

    /**
     * Construtor que recebe uma mensagem de erro como parâmetro
     * @param message Mensagem de erro a ser exibida quando essa exceção é lançada
     */
    public ResourceNotFoundException(String message) {
        super(message); // Chama o construtor da superclasse (Exception) e define a mensagem de erro
    }
}

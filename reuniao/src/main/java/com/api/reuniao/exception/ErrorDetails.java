package com.api.reuniao.exception;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter // Gera automaticamente os getters para os campos da classe
public class ErrorDetails extends Exception { // Classe que representa os detalhes de erro

    private Date timestamp; // Armazena o timestamp do erro
    private String message; // Armazena a mensagem de erro
    private String details; // Armazena os detalhes específicos do erro

    // Construtor que inicializa os campos da classe
    public ErrorDetails(Date timestamp, String message, String details) {
        super(message); // Chama o construtor da classe Exception e define a mensagem de erro

        this.timestamp = timestamp; // Inicializa o timestamp com o valor recebido
        this.message = message; // Inicializa a mensagem de erro com o valor recebido
        this.details = details; // Inicializa os detalhes do erro com o valor recebido
    }
}

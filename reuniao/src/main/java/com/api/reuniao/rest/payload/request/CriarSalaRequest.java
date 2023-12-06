package com.api.reuniao.rest.payload.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class CriarSalaRequest {
    @NotBlank // Indica que o campo não pode ser vazio ou conter apenas espaços em branco
    private String name; // Nome da sala

    @NotBlank
    private String date; // Data da sala

    @NotBlank
    private String startHour; // Hora de início da sala

    @NotBlank
    private String endHour; // Hora de término da sala

}

package com.api.reuniao.mapper;

import com.api.reuniao.entity.Sala;
import com.api.reuniao.rest.payload.request.CriarSalaRequest;

public class SalaMapper {
    public static Sala fromCriarSalaRequestToSala(CriarSalaRequest criarSalaRequest) {
        Sala sala = new Sala();
        sala.setName(criarSalaRequest.getName());
        sala.setDate(criarSalaRequest.getDate());
        sala.setEndHour(criarSalaRequest.getEndHour());
        sala.setStartHour(criarSalaRequest.getStartHour());
        return sala;

    }

}

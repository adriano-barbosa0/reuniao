package com.api.reuniao.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity // Indica que essa classe é uma entidade JPA e será mapeada para uma tabela no banco de dados
@Data // Anotação do Lombok para gerar automaticamente getters, setters, toString(), equals() e hashCode()
@AllArgsConstructor // Cria um construtor com todos os argumentos
@NoArgsConstructor // Cria um construtor vazio
public class Sala {

    @Id // Indica que esse campo é a chave primária da entidade
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Define a estratégia de geração de valor para a chave primária
    private long id; // Identificador único da sala

    private String name; // Nome da sala

    private String date; // Data da sala

    private String startHour; // Hora de início da sala

    private String endHour; // Hora de término da sala

    @Override // Sobrescreve o método toString para representação textual personalizada da entidade
    public String toString() {
        return String.format("Sala [id=%s, name=%s, startHour=%s, endHour=%s]", this.id, this.name, this.startHour,
                this.endHour);
    }
}

package com.api.reuniao.rest.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import com.api.reuniao.entity.Sala;
import com.api.reuniao.repository.SalaRepository;
import com.api.reuniao.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sala") // Define o mapeamento base para todas as rotas neste controlador como "/sala"
@CrossOrigin(origins = "http://127.0.0.1:5500") // Permitir solicitações CORS do endereço do frontend
public class SalaController {

    @Autowired
    private SalaRepository salaRepository; // Injeção de dependência do repositório SalaRepository

    @GetMapping // Mapeia requisições GET para listar todas as salas
    public List<Sala> getAllSalas() {
        return this.salaRepository.findAll(); // Retorna todas as salas usando o método findAll do repositório
    }

    @GetMapping("/{id}") // Mapeia requisições GET para obter uma sala pelo ID
    public ResponseEntity<Sala> getSalaById(@PathVariable long id) throws ResourceNotFoundException {
        var sala = this.salaRepository.findById(id) // Procura uma sala pelo ID
                .orElseThrow(() -> new ResourceNotFoundException("Room not found " + id)); // Lança uma exceção se não encontrar a sala
        return ResponseEntity.ok().body(sala); // Retorna a sala encontrada com o status OK
    }

    @PostMapping // Mapeia requisições POST para criar uma nova sala
    @ResponseStatus(code = HttpStatus.CREATED) // Define o código de resposta para indicar que a sala foi criada com sucesso
    public Sala createSala(@Valid @RequestBody Sala sala) {
        return this.salaRepository.save(sala); // Salva a nova sala usando o método save do repositório
    }

    @PutMapping("/{id}") // Mapeia requisições PUT para atualizar uma sala existente pelo ID
    public ResponseEntity<Sala> updateSala(@PathVariable(value = "id") Long id, @Valid @RequestBody Sala roomDetails) throws ResourceNotFoundException {
        Sala sala = this.salaRepository.findById(id) // Procura a sala pelo ID
                .orElseThrow(() -> new ResourceNotFoundException("Room not found " + id)); // Lança uma exceção se não encontrar a sala

        // Atualiza os detalhes da sala com os valores fornecidos
        sala.setName(roomDetails.getName());
        sala.setDate(roomDetails.getDate());
        sala.setStartHour(roomDetails.getStartHour());
        sala.setEndHour(roomDetails.getEndHour());

        final Sala updatedSala = this.salaRepository.save(sala); // Salva as alterações da sala no repositório

        return ResponseEntity.ok().body(updatedSala); // Retorna a sala atualizada com o status OK
    }

    @DeleteMapping("/{id}") // Mapeia requisições DELETE para excluir uma sala pelo ID
    public Map<String, Boolean> deleteSala(@PathVariable(value = "id") Long id) throws ResourceNotFoundException {
        Sala sala = this.salaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Room not found for this id:" + id));

        salaRepository.delete(sala); // Exclui a sala usando o método delete do repositório
        var response = new HashMap<String, Boolean>();
        response.put("deleted", Boolean.TRUE); // Define um mapa de resposta indicando que a sala foi excluída com sucesso

        return response; // Retorna a resposta de sucesso
    }
}

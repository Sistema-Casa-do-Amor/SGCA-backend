package br.com.casadoamor.sgca.prontuario.controller;

import br.com.casadoamor.sgca.prontuario.model.PerguntaDTO;
import br.com.casadoamor.sgca.prontuario.model.GeneralResponse;
import br.com.casadoamor.sgca.prontuario.service.PerguntaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/1.0/perguntas", produces = "application/json;charset=UTF-8")
public class PerguntaController {

    @Autowired
    private PerguntaService perguntaService;

    @PostMapping(consumes = "application/json")
    public ResponseEntity<GeneralResponse> createPerguntas(@RequestBody @Valid PerguntaDTO perguntaDto) {
        return ResponseEntity.ok(this.perguntaService.createPerguntas(perguntaDto));
    }

    @GetMapping(path="/{id}")
    public ResponseEntity<PerguntaDTO> getPerguntasById(@PathVariable Long id) {
        return ResponseEntity.ok(this.perguntaService.getPerguntasById(id));
    }

    @GetMapping
    public ResponseEntity<List<PerguntaDTO>> getAllPerguntas() {
        return ResponseEntity.ok(this.perguntaService.getAllPerguntas());
    }

    @DeleteMapping(path="/{id}")
    public ResponseEntity<?> deletePerguntas(@PathVariable Long id) {
        this.perguntaService.deletePerguntas(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

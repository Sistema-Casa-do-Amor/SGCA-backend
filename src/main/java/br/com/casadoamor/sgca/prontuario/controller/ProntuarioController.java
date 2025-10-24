package br.com.casadoamor.sgca.prontuario.controller;

import br.com.casadoamor.sgca.prontuario.model.GeneralResponse;
import br.com.casadoamor.sgca.prontuario.model.ProntuarioDTO;
import br.com.casadoamor.sgca.prontuario.service.ProntuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/1.0/prontuario", produces = "application/json;charset=UTF-8")
public class ProntuarioController {

    @Autowired
    private ProntuarioService prontuarioService;

    @PostMapping(consumes = "application/json")
    public ResponseEntity<GeneralResponse> createProntuario(@RequestBody @Valid ProntuarioDTO prontuarioDto) {
        return ResponseEntity.ok(this.prontuarioService.createProntuario(prontuarioDto));
    }

    @GetMapping(path="/{id}")
    public ResponseEntity<ProntuarioDTO> getProntuarioById(@PathVariable Long id) {
        return ResponseEntity.ok(this.prontuarioService.getProntuarioById(id));
    }

    @GetMapping
    public ResponseEntity<List<ProntuarioDTO>> getAllProntuario() {
        return ResponseEntity.ok(this.prontuarioService.getAllProntuario());
    }

    @PutMapping(path="/{id}")
    public ResponseEntity<ProntuarioDTO> updateProntuario(
            @PathVariable Long id,
            @RequestBody ProntuarioDTO prontuarioDto
    ){
        return ResponseEntity.ok(this.prontuarioService.updateProntuario(id, prontuarioDto));
    }

    @DeleteMapping(path="/{id}")
    public ResponseEntity<?> deleteProntuario(@PathVariable Long id) {
        this.prontuarioService.deleteProntuario(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

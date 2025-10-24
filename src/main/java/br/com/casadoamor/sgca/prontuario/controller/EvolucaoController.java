package br.com.casadoamor.sgca.prontuario.controller;

import br.com.casadoamor.sgca.prontuario.model.EvolucaoDTO;
import br.com.casadoamor.sgca.prontuario.model.GeneralResponse;
import br.com.casadoamor.sgca.prontuario.service.EvolucaoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/1.0/evolucao", produces = "application/json;charset=UTF-8")
public class EvolucaoController {

    @Autowired
    private EvolucaoService evolucaoService;

    @PostMapping(consumes = "application/json")
    public ResponseEntity<GeneralResponse> createEvolucao(@RequestBody @Valid EvolucaoDTO evolucaoDto) {
        return ResponseEntity.ok(this.evolucaoService.createEvolucao(evolucaoDto));
    }

    @GetMapping(path="/{id}")
    public ResponseEntity<EvolucaoDTO> getEvolucaoById(@PathVariable Long id) {
        return ResponseEntity.ok(this.evolucaoService.getEvolucaoById(id));
    }

    @GetMapping
    public ResponseEntity<List<EvolucaoDTO>> getAllEvolucao() {
        return ResponseEntity.ok(this.evolucaoService.getAllEvolucao());
    }

    @PutMapping(path="/{id}")
    public ResponseEntity<EvolucaoDTO> updateEvolucao(
            @PathVariable Long id,
            @RequestBody EvolucaoDTO evolucaoDto
    ){
        return ResponseEntity.ok(this.evolucaoService.updateEvolucao(id, evolucaoDto));
    }

    @DeleteMapping(path="/{id}")
    public ResponseEntity<?> deleteEvolucao(@PathVariable Long id) {
        this.evolucaoService.deleteEvolucao(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

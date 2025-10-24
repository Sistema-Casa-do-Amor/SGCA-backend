package br.com.casadoamor.sgca.prontuario.controller;

import br.com.casadoamor.sgca.prontuario.model.ProntuarioGeralDTO;
import br.com.casadoamor.sgca.prontuario.model.GeneralResponse;
import br.com.casadoamor.sgca.prontuario.service.ProntuarioGeralService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/1.0/prontuario-geral", produces = "application/json;charset=UTF-8")
public class ProntuarioGeralController {

    @Autowired
    private ProntuarioGeralService prontuarioGeralService;

    @PostMapping(consumes = "application/json")
    public ResponseEntity<GeneralResponse> createProntuarioGeral(@RequestBody @Valid ProntuarioGeralDTO prontuarioGeralDto) {
        return ResponseEntity.ok(this.prontuarioGeralService.createProntuarioGeral(prontuarioGeralDto));
    }

    @GetMapping(path="/{os}")
    public ResponseEntity<ProntuarioGeralDTO> getProntuarioGeralByOs(@PathVariable Long os) {
        return ResponseEntity.ok(this.prontuarioGeralService.getProntuarioGeralByOs(os));
    }

    @GetMapping
    public ResponseEntity<List<ProntuarioGeralDTO>> getAllProntuarioGeral() {
        return ResponseEntity.ok(this.prontuarioGeralService.getAllProntuarioGeral());
    }

    @PutMapping(path="/{os}")
    public ResponseEntity<ProntuarioGeralDTO> updateProntuarioGeral(
            @PathVariable Long os,
            @RequestBody ProntuarioGeralDTO prontuarioGeralDto
    ){
        return ResponseEntity.ok(this.prontuarioGeralService.updateProntuarioGeral(os, prontuarioGeralDto));
    }

    @DeleteMapping(path="/{os}")
    public ResponseEntity<?> deleteProntuarioGeral(@PathVariable Long os) {
        this.prontuarioGeralService.deleteProntuarioGeral(os);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

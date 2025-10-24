package br.com.casadoamor.sgca.prontuario.controller;

import br.com.casadoamor.sgca.prontuario.model.RespostaDTO;
import br.com.casadoamor.sgca.prontuario.model.GeneralResponse;
import br.com.casadoamor.sgca.prontuario.service.RespostaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/1.0/resposta", produces = "application/json;charset=UTF-8")
public class RespostaController {

    @Autowired
    private RespostaService respostaService;

    @PostMapping(consumes = "application/json")
    public ResponseEntity<GeneralResponse> createResposta(@RequestBody @Valid RespostaDTO respostaDto) {
        return ResponseEntity.ok(this.respostaService.createResposta(respostaDto));
    }

    @GetMapping(path="/{id}")
    public ResponseEntity<RespostaDTO> getRespostaById(@PathVariable Long id) {
        return ResponseEntity.ok(this.respostaService.getRespostaById(id));
    }

    @GetMapping
    public ResponseEntity<List<RespostaDTO>> getAllRespostaByRegistro(@PathVariable Long registroId) {
        return ResponseEntity.ok(this.respostaService.getAllRespostaByRegistro(registroId));
    }

    @PutMapping(path="/{id}")
    public ResponseEntity<RespostaDTO> updateResposta(
            @PathVariable Long id,
            @RequestBody RespostaDTO respostaDto
    ){
        return ResponseEntity.ok(this.respostaService.updateResposta(id, respostaDto));
    }

    @DeleteMapping(path="/{id}")
    public ResponseEntity<?> deleteResposta(@PathVariable Long id) {
        this.respostaService.deleteResposta(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

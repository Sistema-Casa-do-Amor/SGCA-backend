package br.com.casadoamor.sgca.administracao.controller;

import br.com.casadoamor.sgca.administracao.dto.PessoaFisicaDTO;
import br.com.casadoamor.sgca.administracao.service.PessoaFisicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/1.0", produces = "application/json;charset=UTF-8")
public class PessoaFisicaController {

    @Autowired
    private PessoaFisicaService pessoaFisicaService;

    @PostMapping(path="/pessoa-fisica")
    public ResponseEntity<PessoaFisicaDTO> createPessoaFisica(@RequestBody PessoaFisicaDTO pessoaFisicaDto) {
        return new ResponseEntity<>(this.pessoaFisicaService.createPessoaFisica(pessoaFisicaDto), HttpStatus.CREATED);
    }

    @GetMapping(path="/pessoa-fisica/{id}")
    public ResponseEntity<PessoaFisicaDTO> getPessoaFisicaById(@PathVariable Long id) {
        return new ResponseEntity<>(this.pessoaFisicaService.getPessoaFisicaById(id), HttpStatus.OK);
    }

    @GetMapping(path="/pessoa-fisica/{nome}/nome")
    public ResponseEntity<List<PessoaFisicaDTO>> getPessoaFisicaById(@PathVariable String nome) {
        return new ResponseEntity<>(this.pessoaFisicaService.findByNomeContaining(nome), HttpStatus.OK);
    }

    @GetMapping(path="/pessoa-fisica/{cpf:[0-9.-]+}/cpf")
    public ResponseEntity<PessoaFisicaDTO> getPessoaFisicaByCpf(@PathVariable String cpf) {
        return new ResponseEntity<>(this.pessoaFisicaService.getPessoaFisicaByCpf(cpf), HttpStatus.OK);
    }

    @GetMapping(path = "/pessoa-fisica")
    public ResponseEntity<List<PessoaFisicaDTO>> getAllPessoaFisica() {
        return new ResponseEntity<>(this.pessoaFisicaService.getAllPessoaFisica(), HttpStatus.OK);
    }

    @PutMapping(path="/pessoa-fisica/{id}")
    public ResponseEntity<PessoaFisicaDTO> updatePessoaFisica(
            @PathVariable Long id,
            @RequestBody PessoaFisicaDTO pessoaFisicaDto
    ){
        return new ResponseEntity<>(this.pessoaFisicaService.updatePessoaFisica(id, pessoaFisicaDto), HttpStatus.OK);
    }

    @DeleteMapping(path="/pessoa-fisica/{id}")
    public ResponseEntity<PessoaFisicaDTO> deletePessoaFisica(@PathVariable Long id) {
        this.pessoaFisicaService.deletePessoaFisica(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

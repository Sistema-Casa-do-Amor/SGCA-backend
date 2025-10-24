package br.com.casadoamor.sgca.administracao.controller;

import br.com.casadoamor.sgca.administracao.dto.UsuarioDTO;
import br.com.casadoamor.sgca.administracao.dto.UsuarioRequestJson;
import br.com.casadoamor.sgca.administracao.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/1.0", produces = "application/json;charset=UTF-8")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping(path="/usuario")
    public ResponseEntity<UsuarioDTO> createUsuario(@RequestBody UsuarioRequestJson usuarioRequestJson) {
        return new ResponseEntity<>(this.usuarioService.createUsuario(usuarioRequestJson), HttpStatus.CREATED);
    }

    @GetMapping(path="/usuario/{id}")
    public ResponseEntity<UsuarioDTO> getUsuarioById(@PathVariable Long id) {
        return new ResponseEntity<>(this.usuarioService.getUsuarioById(id), HttpStatus.OK);
    }

    @GetMapping(path="/usuario/{cpf:[0-9.-]+}/cpf")
    public ResponseEntity<UsuarioDTO> getUsuarioByCpf(@PathVariable String cpf) {
        return new ResponseEntity<>(this.usuarioService.getUsuarioByCpf(cpf), HttpStatus.OK);
    }

    @GetMapping(path = "/usuario")
    public ResponseEntity<List<UsuarioDTO>> getAllUsuario() {
        return new ResponseEntity<>(this.usuarioService.getAllUsuario(), HttpStatus.OK);
    }

    @PutMapping(path="/usuario/{id}")
    public ResponseEntity<UsuarioDTO> updateUsuario(
            @PathVariable Long id,
            @RequestBody UsuarioDTO usuarioDto
    ){
        return new ResponseEntity<>(this.usuarioService.updateUsuario(id, usuarioDto), HttpStatus.OK);
    }

    @DeleteMapping(path="/usuario/{id}")
    public ResponseEntity<UsuarioDTO> deleteUsuario(@PathVariable Long id) {
        this.usuarioService.deleteUsuario(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

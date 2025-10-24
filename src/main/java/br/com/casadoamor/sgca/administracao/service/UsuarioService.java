package br.com.casadoamor.sgca.administracao.service;

import br.com.casadoamor.sgca.administracao.dto.UsuarioDTO;
import br.com.casadoamor.sgca.administracao.dto.UsuarioRequestJson;

import java.util.List;

public interface UsuarioService {
    UsuarioDTO createUsuario(UsuarioRequestJson usuarioRequestJson);
    UsuarioDTO getUsuarioById(Long id);
    UsuarioDTO getUsuarioByCpf(String cpf);
    List<UsuarioDTO> getAllUsuario();
    UsuarioDTO updateUsuario(Long id, UsuarioDTO usuarioDto);
    void deleteUsuario(Long id);
}

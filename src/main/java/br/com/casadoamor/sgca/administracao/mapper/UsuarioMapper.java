package br.com.casadoamor.sgca.administracao.mapper;

import br.com.casadoamor.sgca.administracao.dto.UsuarioDTO;
import br.com.casadoamor.sgca.administracao.dto.UsuarioRequestJson;
import br.com.casadoamor.sgca.administracao.entity.Usuario;

public class UsuarioMapper {

    public static UsuarioDTO toUsuarioDto(Usuario usuario) {
        return new UsuarioDTO(
                usuario.getId(),
                usuario.getCpf(),
                usuario.getSenha(),
                usuario.isAtivo(),
                PessoaFisicaMapper.toPessoaFisicaDto(usuario.getPessoaFisica())
        );
    }

    public static Usuario toUsuario(UsuarioDTO usuario) {
        return new Usuario(
                usuario.getId(),
                usuario.getCpf(),
                usuario.getSenha(),
                usuario.isAtivo(),
                PessoaFisicaMapper.toPessoaFisica(usuario.getPessoaFisica())
        );
    }

    public static Usuario toUsuario(UsuarioRequestJson usuario) {
        return new Usuario(
                usuario.getId(),
                usuario.getCpf(),
                usuario.getSenha(),
                usuario.isAtivo(),
                null
        );
    }
}

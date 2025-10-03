package br.com.casadoamor.sgca.administracao.mapper;

import br.com.casadoamor.sgca.administracao.dto.UsuarioDto;
import br.com.casadoamor.sgca.administracao.dto.UsuarioRequestJson;
import br.com.casadoamor.sgca.administracao.entity.Usuario;

public class UsuarioMapper {

    public static UsuarioDto toUsuarioDto(Usuario usuario) {
        return new UsuarioDto(
                usuario.getId(),
                usuario.getCpf(),
                usuario.getSenha(),
                usuario.isAtivo(),
                PessoaFisicaMapper.toPessoaFisicaDto(usuario.getPessoaFisica())
        );
    }

    public static Usuario toUsuario(UsuarioDto usuario) {
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

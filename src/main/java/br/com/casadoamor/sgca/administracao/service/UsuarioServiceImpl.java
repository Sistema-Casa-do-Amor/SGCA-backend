package br.com.casadoamor.sgca.administracao.service;

import br.com.casadoamor.sgca.administracao.dto.UsuarioDTO;
import br.com.casadoamor.sgca.administracao.dto.UsuarioRequestJson;
import br.com.casadoamor.sgca.administracao.entity.Usuario;
import br.com.casadoamor.sgca.exception.ResourceNotFoundException;
import br.com.casadoamor.sgca.administracao.mapper.PessoaFisicaMapper;
import br.com.casadoamor.sgca.administracao.mapper.UsuarioMapper;
import br.com.casadoamor.sgca.administracao.repository.PessoaFisicaRepository;
import br.com.casadoamor.sgca.administracao.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PessoaFisicaRepository pessoaFisicaRepository;

    @Override
    public UsuarioDTO createUsuario(UsuarioRequestJson requestJson) {
        requestJson.setCpf(requestJson.getCpf().replace(".", "").replace("-", ""));
        Usuario usuario = UsuarioMapper.toUsuario(requestJson);

        usuario.setPessoaFisica(this.pessoaFisicaRepository.findById(requestJson.getPessoaFisica()).orElseThrow(() ->
                new ResourceNotFoundException("Pessoa Fisica com id " + requestJson.getPessoaFisica() + "não encontrada!")));

        return UsuarioMapper.toUsuarioDto(usuarioRepository.save(usuario));
    }

    @Override
    public UsuarioDTO getUsuarioById(Long id) {
        return UsuarioMapper.toUsuarioDto(
                this.usuarioRepository.findById(id)
                        .orElseThrow(() ->
                                new ResourceNotFoundException("Usuário com id " + id + "não encontrado!"))
        );
    }

    @Override
    public UsuarioDTO getUsuarioByCpf(String cpf) {
        String cpfFormatted = cpf.replace(".", "").replace("-", "");
        return UsuarioMapper.toUsuarioDto(this.usuarioRepository.findByCpf(cpfFormatted)
                .orElseThrow(() -> new ResourceNotFoundException("Usuário com CPF " + cpf + " não encontrada!")));
    }

    @Override
    public List<UsuarioDTO> getAllUsuario() {
        return this.usuarioRepository.findAll().stream()
                .map(UsuarioMapper::toUsuarioDto).collect(Collectors.toList());
    }

    @Override
    public UsuarioDTO updateUsuario(Long id, UsuarioDTO usuarioDto) {
        Usuario user = this.usuarioRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Usuário com id " + id + "não encontrado!"));
        user.setCpf(usuarioDto.getCpf());
        user.setSenha(usuarioDto.getSenha());
        user.setAtivo(usuarioDto.isAtivo());
        user.setPessoaFisica(PessoaFisicaMapper.toPessoaFisica(usuarioDto.getPessoaFisica()));
        return UsuarioMapper.toUsuarioDto(this.usuarioRepository.save(user));
    }

    @Override
    public void deleteUsuario(Long id) {
        this.usuarioRepository.deleteById(id);
    }
}
package br.com.casadoamor.sgca.administracao.service;

import br.com.casadoamor.sgca.administracao.dto.PessoaFisicaDTO;
import br.com.casadoamor.sgca.administracao.entity.PessoaFisica;
import br.com.casadoamor.sgca.exception.ResourceNotFoundException;
import br.com.casadoamor.sgca.administracao.mapper.PessoaFisicaMapper;
import br.com.casadoamor.sgca.administracao.repository.PessoaFisicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PessoaFisicaServiceImpl implements PessoaFisicaService {

    @Autowired
    private PessoaFisicaRepository pessoaFisicaRepository;

    @Override
    public PessoaFisicaDTO createPessoaFisica(PessoaFisicaDTO pessoaFisicaDto) {
        pessoaFisicaDto.setCpf(pessoaFisicaDto.getCpf().replace(".", "").replace("-", ""));
        pessoaFisicaDto.getEndereco().setCep(pessoaFisicaDto.getEndereco().getCep().replace("-", ""));

        PessoaFisica pessoa = PessoaFisicaMapper.toPessoaFisica(pessoaFisicaDto);
        return PessoaFisicaMapper.toPessoaFisicaDto(this.pessoaFisicaRepository.save(pessoa));
    }

    @Override
    public PessoaFisicaDTO getPessoaFisicaById(Long id) {
        return PessoaFisicaMapper.toPessoaFisicaDto(
                this.pessoaFisicaRepository.findById(id)
                        .orElseThrow(() ->
                                new ResourceNotFoundException("Pessoa Fisica com id " + id + " não encontrada!"))
        );
    }

    @Override
    public List<PessoaFisicaDTO> getAllPessoaFisica() {
        return this.pessoaFisicaRepository.findAll()
                .stream().map(PessoaFisicaMapper::toPessoaFisicaDto).collect(Collectors.toList());
    }

    @Override
    public PessoaFisicaDTO getPessoaFisicaByCpf(String cpf) {
        String cpfFormatted = cpf.replace(".", "").replace("-", "");
        return PessoaFisicaMapper.toPessoaFisicaDto(this.pessoaFisicaRepository.findByCpf(cpfFormatted)
                .orElseThrow(() -> new ResourceNotFoundException("Pessoa Fisica com CPF " + cpf + " não encontrada!")));
    }

    public List<PessoaFisicaDTO> findByNomeContaining(String nome) {
        return this.pessoaFisicaRepository.findByNomeContaining(nome).stream()
                .map(PessoaFisicaMapper::toPessoaFisicaDto).collect(Collectors.toList());
    }

    @Override
    public PessoaFisicaDTO updatePessoaFisica(Long id, PessoaFisicaDTO pessoaFisicaDto) {
        PessoaFisica pessoa = this.pessoaFisicaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Pessoa Fisica com id " + id + " não encontrada!"));
        pessoa.setNome(pessoaFisicaDto.getNome());
        pessoa.setDataNascimento(pessoaFisicaDto.getDataNascimento());
        pessoa.setCpf(pessoaFisicaDto.getCpf());
        pessoa.setRg(pessoaFisicaDto.getRg());
        pessoa.setTelefone(pessoaFisicaDto.getTelefone());
        pessoa.setEmail(pessoaFisicaDto.getEmail());
        pessoa.getEndereco().setEndereco(pessoaFisicaDto.getEndereco().getEndereco());
        pessoa.getEndereco().setBairro(pessoaFisicaDto.getEndereco().getBairro());
        pessoa.getEndereco().setNumero(pessoaFisicaDto.getEndereco().getNumero());
        pessoa.getEndereco().setCidade(pessoaFisicaDto.getEndereco().getCidade());
        pessoa.getEndereco().setEstado(pessoaFisicaDto.getEndereco().getEstado());
        pessoa.getEndereco().setCep(pessoaFisicaDto.getEndereco().getCep());
        pessoa.getEndereco().setComplemento(pessoaFisicaDto.getEndereco().getComplemento());

        return PessoaFisicaMapper.toPessoaFisicaDto(this.pessoaFisicaRepository.save(pessoa));
    }

    @Override
    public void deletePessoaFisica(Long id) {
        this.pessoaFisicaRepository.deleteById(id);
    }


}

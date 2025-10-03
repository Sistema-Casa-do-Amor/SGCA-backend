package br.com.casadoamor.sgca.administracao.service;

import br.com.casadoamor.sgca.administracao.dto.ProfissionalSaudeDto;
import br.com.casadoamor.sgca.administracao.dto.ProfissionalSaudeRequestJson;
import br.com.casadoamor.sgca.administracao.entity.ProfissionalSaude;
import br.com.casadoamor.sgca.administracao.exception.ResourceNotFoundException;
import br.com.casadoamor.sgca.administracao.mapper.ProfissionalSaudeMapper;
import br.com.casadoamor.sgca.administracao.repository.PessoaFisicaRepository;
import br.com.casadoamor.sgca.administracao.repository.ProfissionalSaudeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProfissionalSaudeServiceImpl implements ProfissionalSaudeService {

    @Autowired
    private ProfissionalSaudeRepository profissionalSaudeRepository;

    @Autowired
    private PessoaFisicaRepository pessoaFisicaRepository;

    @Override
    public ProfissionalSaudeDto createProfissionalSaude(ProfissionalSaudeRequestJson profissional) {
        ProfissionalSaude profissionalSaude = ProfissionalSaudeMapper.toProfissionalSaude(profissional);

        profissionalSaude.setPessoaFisica(this.pessoaFisicaRepository.findById(profissional.getPessoaFisica())
                .orElseThrow(() ->
                        new ResourceNotFoundException("Pessoa Fisica com id " + profissional.getPessoaFisica() + "não encontrada!")));
        return ProfissionalSaudeMapper.toProfissionalSaudeDto(this.profissionalSaudeRepository.save(profissionalSaude));
    }

    @Override
    public ProfissionalSaudeDto getProfissionalSaudeById(Long id) {
        return ProfissionalSaudeMapper.toProfissionalSaudeDto(
                this.profissionalSaudeRepository.findById(id)
                        .orElseThrow(() ->
                                new ResourceNotFoundException("Profissional de Saude com id " + id + "não encontrado!"))
        );
    }

    @Override
    public List<ProfissionalSaudeDto> getAllProfissionalSaude() {
        return this.profissionalSaudeRepository.findAll().stream()
                .map(ProfissionalSaudeMapper::toProfissionalSaudeDto).collect(Collectors.toList());
    }

    @Override
    public ProfissionalSaudeDto updateProfissionalSaude(Long id, ProfissionalSaudeRequestJson profissionalSaudeDto) {
        ProfissionalSaude profissional = this.profissionalSaudeRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Profissional de Saude com id " + id + "não encontrado!"));
        profissional.setTipo(profissionalSaudeDto.getTipo());
        profissional.setDocumento(profissionalSaudeDto.getDocumento());
        profissional.setUfDocumento(profissionalSaudeDto.getUfDocumento());
        profissional.setEspecialidade(profissionalSaudeDto.getEspecialidade());
        profissional.setPessoaFisica(this.pessoaFisicaRepository.findById(profissionalSaudeDto.getPessoaFisica())
                .orElseThrow(() ->
                        new ResourceNotFoundException("Pessoa Fisica com id " + profissionalSaudeDto.getPessoaFisica() + "não encontrada!")));
        return ProfissionalSaudeMapper.toProfissionalSaudeDto(profissional);
    }

    @Override
    public void deleteProfissionalSaude(Long id) {
        this.profissionalSaudeRepository.deleteById(id);
    }
}
package br.com.casadoamor.sgca.prontuario.service;

import br.com.casadoamor.sgca.exception.ResourceNotFoundException;
import br.com.casadoamor.sgca.prontuario.entity.Prontuario;
import br.com.casadoamor.sgca.prontuario.model.ProntuarioDTO;
import br.com.casadoamor.sgca.prontuario.model.GeneralResponse;
import br.com.casadoamor.sgca.prontuario.repository.ProntuarioRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProntuarioServiceImpl implements ProntuarioService {

    @Autowired
    private ProntuarioRepository prontuarioRepository;

    @Autowired
    private ModelMapper mapper;

    @Override
    public GeneralResponse createProntuario(ProntuarioDTO prontuarioDto) {
        if(prontuarioDto.getDataAbertura() == null) prontuarioDto.setDataAbertura(Date.valueOf(LocalDate.now()));
        Prontuario prontuario = this.mapper.map(prontuarioDto, Prontuario.class);
        return this.mapper.map(this.prontuarioRepository.save(prontuario), GeneralResponse.class);
    }

    @Override
    public ProntuarioDTO getProntuarioById(Long id) {
        return this.mapper.map(this.prontuarioRepository.getById(id), ProntuarioDTO.class);
    }

    @Override
    public List<ProntuarioDTO> getAllProntuario() {
        return this.prontuarioRepository.findAll().stream()
                .map(pront -> this.mapper.map(pront, ProntuarioDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public ProntuarioDTO updateProntuario(Long id, ProntuarioDTO prontuarioDto) {
        checkIfExist(id);
        prontuarioDto.setId(id);
        Prontuario p = this.prontuarioRepository.save(this.mapper.map(prontuarioDto, Prontuario.class));
        return this.mapper.map(p, ProntuarioDTO.class);
    }

    @Override
    public void deleteProntuario(Long id) {
        checkIfExist(id);
        this.prontuarioRepository.deleteById(id);
    }

    public void checkIfExist(Long id) {
        this.prontuarioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Prontuário com id " + id + " não encontrado!"));
    }
}

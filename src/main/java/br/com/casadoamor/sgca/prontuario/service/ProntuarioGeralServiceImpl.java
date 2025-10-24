package br.com.casadoamor.sgca.prontuario.service;

import br.com.casadoamor.sgca.exception.ResourceNotFoundException;
import br.com.casadoamor.sgca.prontuario.entity.ProntuarioGeral;
import br.com.casadoamor.sgca.prontuario.model.ProntuarioGeralDTO;
import br.com.casadoamor.sgca.prontuario.model.GeneralResponse;
import br.com.casadoamor.sgca.prontuario.repository.ProntuarioGeralRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProntuarioGeralServiceImpl implements ProntuarioGeralService {

    @Autowired
    private ProntuarioGeralRepository prontuarioGeralRepository;

    @Autowired
    private ModelMapper mapper;

    @Override
    public GeneralResponse createProntuarioGeral(ProntuarioGeralDTO prontuarioGeralDto) {
        if(prontuarioGeralDto.getDataChegada() == null) prontuarioGeralDto.setDataChegada(Date.valueOf(LocalDate.now()));
        ProntuarioGeral prontuarioGeral = this.mapper.map(prontuarioGeralDto, ProntuarioGeral.class);
        return this.mapper.map(this.prontuarioGeralRepository.save(prontuarioGeral), GeneralResponse.class);
    }

    @Override
    public ProntuarioGeralDTO getProntuarioGeralByOs(Long os) {
        return this.mapper.map(this.prontuarioGeralRepository.getById(os), ProntuarioGeralDTO.class);
    }

    @Override
    public List<ProntuarioGeralDTO> getAllProntuarioGeral() {
        return this.prontuarioGeralRepository.findAll().stream()
                .map(pront -> this.mapper.map(pront, ProntuarioGeralDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public ProntuarioGeralDTO updateProntuarioGeral(Long os, ProntuarioGeralDTO prontuarioGeralDto) {
        checkIfExist(os);
        prontuarioGeralDto.setOs(os);
        ProntuarioGeral p = this.prontuarioGeralRepository.save(this.mapper.map(prontuarioGeralDto, ProntuarioGeral.class));
        return this.mapper.map(p, ProntuarioGeralDTO.class);
    }

    @Override
    public void deleteProntuarioGeral(Long os) {
        checkIfExist(os);
        this.prontuarioGeralRepository.deleteById(os);
    }

    public void checkIfExist(Long os) {
        this.prontuarioGeralRepository.findById(os)
                .orElseThrow(() -> new ResourceNotFoundException("Prontuário Geral com id " + os + " não encontrado!"));
    }
}

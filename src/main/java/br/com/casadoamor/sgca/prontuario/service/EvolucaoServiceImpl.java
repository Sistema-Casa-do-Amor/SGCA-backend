package br.com.casadoamor.sgca.prontuario.service;

import br.com.casadoamor.sgca.exception.ResourceNotFoundException;
import br.com.casadoamor.sgca.prontuario.entity.Evolucao;
import br.com.casadoamor.sgca.prontuario.model.EvolucaoDTO;
import br.com.casadoamor.sgca.prontuario.model.GeneralResponse;
import br.com.casadoamor.sgca.prontuario.repository.EvolucaoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EvolucaoServiceImpl implements EvolucaoService {

    @Autowired
    private EvolucaoRepository evolucaoRepository;

    @Autowired
    private ModelMapper mapper;

    @Override
    public GeneralResponse createEvolucao(EvolucaoDTO evolucaoDto) {
        if(evolucaoDto.getDataAbertura() == null) evolucaoDto.setDataAbertura(Date.valueOf(LocalDate.now()));
        Evolucao evolucao = this.mapper.map(evolucaoDto, Evolucao.class);
        return this.mapper.map(this.evolucaoRepository.save(evolucao), GeneralResponse.class);
    }

    @Override
    public EvolucaoDTO getEvolucaoById(Long id) {
        return this.mapper.map(this.evolucaoRepository.getById(id), EvolucaoDTO.class);
    }

    @Override
    public List<EvolucaoDTO> getAllEvolucao() {
        return this.evolucaoRepository.findAll().stream()
                .map(evol -> this.mapper.map(evol, EvolucaoDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public EvolucaoDTO updateEvolucao(Long id, EvolucaoDTO evolucaoDto) {
        checkIfExist(id);
        evolucaoDto.setId(id);
        Evolucao p = this.evolucaoRepository.save(this.mapper.map(evolucaoDto, Evolucao.class));
        return this.mapper.map(p, EvolucaoDTO.class);
    }

    @Override
    public void deleteEvolucao(Long id) {
        checkIfExist(id);
        this.evolucaoRepository.deleteById(id);
    }

    public void checkIfExist(Long id) {
        this.evolucaoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Evolução com id " + id + " não encontrada!"));
    }
}

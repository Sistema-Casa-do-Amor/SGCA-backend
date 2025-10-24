package br.com.casadoamor.sgca.prontuario.service;

import br.com.casadoamor.sgca.prontuario.model.EvolucaoDTO;
import br.com.casadoamor.sgca.prontuario.model.GeneralResponse;

import java.util.List;

public interface EvolucaoService {
    GeneralResponse createEvolucao(EvolucaoDTO evolucaoDto);

    EvolucaoDTO getEvolucaoById(Long id);

    List<EvolucaoDTO> getAllEvolucao();

    EvolucaoDTO updateEvolucao(Long id, EvolucaoDTO evolucaoDto);

    void deleteEvolucao(Long id);
}

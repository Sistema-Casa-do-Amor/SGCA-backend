package br.com.casadoamor.sgca.administracao.service;

import br.com.casadoamor.sgca.administracao.dto.ProfissionalSaudeDTO;
import br.com.casadoamor.sgca.administracao.dto.ProfissionalSaudeRequestJson;

import java.util.List;

public interface ProfissionalSaudeService {

    ProfissionalSaudeDTO createProfissionalSaude(ProfissionalSaudeRequestJson profissional);
    ProfissionalSaudeDTO getProfissionalSaudeById(Long id);
    List<ProfissionalSaudeDTO> getAllProfissionalSaude();
    ProfissionalSaudeDTO updateProfissionalSaude(Long id, ProfissionalSaudeRequestJson profissional);
    void deleteProfissionalSaude(Long id);
}

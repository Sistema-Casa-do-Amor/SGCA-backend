package br.com.casadoamor.sgca.administracao.service;

import br.com.casadoamor.sgca.administracao.dto.ProfissionalSaudeDto;
import br.com.casadoamor.sgca.administracao.dto.ProfissionalSaudeRequestJson;

import java.util.List;

public interface ProfissionalSaudeService {

    ProfissionalSaudeDto createProfissionalSaude(ProfissionalSaudeRequestJson profissional);
    ProfissionalSaudeDto getProfissionalSaudeById(Long id);
    List<ProfissionalSaudeDto> getAllProfissionalSaude();
    ProfissionalSaudeDto updateProfissionalSaude(Long id, ProfissionalSaudeRequestJson profissional);
    void deleteProfissionalSaude(Long id);
}

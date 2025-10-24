package br.com.casadoamor.sgca.prontuario.service;

import br.com.casadoamor.sgca.prontuario.model.ProntuarioDTO;
import br.com.casadoamor.sgca.prontuario.model.GeneralResponse;

import java.util.List;

public interface ProntuarioService {
    GeneralResponse createProntuario(ProntuarioDTO prontuarioDto);

    ProntuarioDTO getProntuarioById(Long id);

    List<ProntuarioDTO> getAllProntuario();

    ProntuarioDTO updateProntuario(Long id, ProntuarioDTO prontuarioDto);

    void deleteProntuario(Long id);
}

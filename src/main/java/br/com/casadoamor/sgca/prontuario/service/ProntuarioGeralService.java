package br.com.casadoamor.sgca.prontuario.service;

import br.com.casadoamor.sgca.prontuario.model.ProntuarioGeralDTO;
import br.com.casadoamor.sgca.prontuario.model.GeneralResponse;

import java.util.List;

public interface ProntuarioGeralService {
    GeneralResponse createProntuarioGeral(ProntuarioGeralDTO prontuarioGeralDto);

    ProntuarioGeralDTO getProntuarioGeralByOs(Long os);

    List<ProntuarioGeralDTO> getAllProntuarioGeral();

    ProntuarioGeralDTO updateProntuarioGeral(Long os, ProntuarioGeralDTO prontuarioGeralDto);

    void deleteProntuarioGeral(Long os);
}

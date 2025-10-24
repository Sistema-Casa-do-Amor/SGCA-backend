package br.com.casadoamor.sgca.prontuario.service;

import br.com.casadoamor.sgca.prontuario.model.RespostaDTO;
import br.com.casadoamor.sgca.prontuario.model.GeneralResponse;

import java.util.List;

public interface RespostaService {
    GeneralResponse createResposta(RespostaDTO respostaDto);

    RespostaDTO getRespostaById(Long id);

    List<RespostaDTO> getAllRespostaByRegistro(Long registroId);

    RespostaDTO updateResposta(Long id, RespostaDTO respostaDto);

    void deleteResposta(Long id);
}

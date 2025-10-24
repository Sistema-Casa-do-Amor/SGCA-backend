package br.com.casadoamor.sgca.prontuario.service;

import br.com.casadoamor.sgca.prontuario.model.PerguntaDTO;
import br.com.casadoamor.sgca.prontuario.model.GeneralResponse;

import java.util.List;

public interface PerguntaService {
    GeneralResponse createPerguntas(PerguntaDTO perguntaDto);

    PerguntaDTO getPerguntasById(Long id);

    List<PerguntaDTO> getAllPerguntas();

    void deletePerguntas(Long id);
}

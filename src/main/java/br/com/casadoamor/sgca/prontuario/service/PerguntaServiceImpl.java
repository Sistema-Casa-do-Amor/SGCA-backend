package br.com.casadoamor.sgca.prontuario.service;

import br.com.casadoamor.sgca.exception.ResourceNotFoundException;
import br.com.casadoamor.sgca.prontuario.entity.Pergunta;
import br.com.casadoamor.sgca.prontuario.model.PerguntaDTO;
import br.com.casadoamor.sgca.prontuario.model.GeneralResponse;
import br.com.casadoamor.sgca.prontuario.repository.PerguntaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PerguntaServiceImpl implements PerguntaService {

    @Autowired
    private PerguntaRepository perguntaRepository;

    @Autowired
    private ModelMapper mapper;

    @Override
    public GeneralResponse createPerguntas(PerguntaDTO perguntaDto) {
        Pergunta pergunta = this.mapper.map(perguntaDto, Pergunta.class);
        return this.mapper.map(this.perguntaRepository.save(pergunta), GeneralResponse.class);
    }

    @Override
    public PerguntaDTO getPerguntasById(Long id) {
        return this.mapper.map(this.perguntaRepository.getById(id), PerguntaDTO.class);
    }

    @Override
    public List<PerguntaDTO> getAllPerguntas() {
        return this.perguntaRepository.findAll().stream()
                .map(perg -> this.mapper.map(perg, PerguntaDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public void deletePerguntas(Long id) {
        checkIfExist(id);
        this.perguntaRepository.deleteById(id);
    }

    public void checkIfExist(Long id) {
        this.perguntaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Pergunta com id " + id + " não encontrada!"));
    }
}

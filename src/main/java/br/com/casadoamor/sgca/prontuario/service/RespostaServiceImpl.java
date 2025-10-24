package br.com.casadoamor.sgca.prontuario.service;

import br.com.casadoamor.sgca.exception.ResourceNotFoundException;
import br.com.casadoamor.sgca.prontuario.entity.Resposta;
import br.com.casadoamor.sgca.prontuario.model.GeneralResponse;
import br.com.casadoamor.sgca.prontuario.model.RespostaDTO;
import br.com.casadoamor.sgca.prontuario.repository.RespostaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RespostaServiceImpl implements RespostaService {

    @Autowired
    private RespostaRepository respostaRepository;

    @Autowired
    private ModelMapper mapper;

    @Override
    public GeneralResponse createResposta(RespostaDTO respostaDto) {
        Resposta resposta = this.mapper.map(respostaDto, Resposta.class);
        return this.mapper.map(this.respostaRepository.save(resposta), GeneralResponse.class);
    }

    @Override
    public RespostaDTO getRespostaById(Long id) {
        return this.mapper.map(this.respostaRepository.getById(id), RespostaDTO.class);
    }

    @Override
    public List<RespostaDTO> getAllRespostaByRegistro(Long registroId) {
        return this.respostaRepository.findByRegistroClinico_Id(registroId).stream()
                .map(evol -> this.mapper.map(evol, RespostaDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public RespostaDTO updateResposta(Long id, RespostaDTO respostaDto) {
        checkIfExist(id);
        respostaDto.setId(id);
        Resposta p = this.respostaRepository.save(this.mapper.map(respostaDto, Resposta.class));
        return this.mapper.map(p, RespostaDTO.class);
    }

    @Override
    public void deleteResposta(Long id) {
        checkIfExist(id);
        this.respostaRepository.deleteById(id);
    }

    public void checkIfExist(Long id) {
        this.respostaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Resposta com id " + id + " não encontrada!"));
    }
}

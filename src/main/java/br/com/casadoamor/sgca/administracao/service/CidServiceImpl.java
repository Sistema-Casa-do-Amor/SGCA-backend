package br.com.casadoamor.sgca.administracao.service;

import br.com.casadoamor.sgca.administracao.dto.CidDTO;
import br.com.casadoamor.sgca.administracao.mapper.CidMapper;
import br.com.casadoamor.sgca.administracao.repository.CidRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CidServiceImpl implements CidService {

    @Autowired
    private CidRepository cidRepository;


    @Override
    public List<CidDTO> getCidById(String id) {
        id = id.replace(".", "");
        return this.cidRepository.findCidBySubcatContaining(id).stream()
                .map(CidMapper::toCidDto).collect(Collectors.toList());
    }

    @Override
    public List<CidDTO> getCidByDescricao(String descricao) {
        return this.cidRepository.findCidByDescricaoContaining(descricao).stream()
                .map(CidMapper::toCidDto).collect(Collectors.toList());
    }

    @Override
    public List<CidDTO> getAllCid() {
        return this.cidRepository.findAll().stream()
                .map(CidMapper::toCidDto).collect(Collectors.toList());
    }
}
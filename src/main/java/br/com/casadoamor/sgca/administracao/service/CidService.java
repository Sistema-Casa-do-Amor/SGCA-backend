package br.com.casadoamor.sgca.administracao.service;

import br.com.casadoamor.sgca.administracao.dto.CidDto;

import java.util.List;

public interface CidService {
    List<CidDto> getCidById(String id);
    List<CidDto> getCidByDescricao(String descricao);
    List<CidDto> getAllCid();
}

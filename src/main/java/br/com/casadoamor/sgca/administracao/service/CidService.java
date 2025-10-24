package br.com.casadoamor.sgca.administracao.service;

import br.com.casadoamor.sgca.administracao.dto.CidDTO;

import java.util.List;

public interface CidService {
    List<CidDTO> getCidById(String id);
    List<CidDTO> getCidByDescricao(String descricao);
    List<CidDTO> getAllCid();
}

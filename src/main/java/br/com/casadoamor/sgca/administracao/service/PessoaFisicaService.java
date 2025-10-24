package br.com.casadoamor.sgca.administracao.service;

import br.com.casadoamor.sgca.administracao.dto.PessoaFisicaDTO;

import java.util.List;

public interface PessoaFisicaService {

    PessoaFisicaDTO createPessoaFisica(PessoaFisicaDTO pessoaFisicaDto);
    PessoaFisicaDTO getPessoaFisicaById(Long id);
    List<PessoaFisicaDTO> getAllPessoaFisica();
    PessoaFisicaDTO updatePessoaFisica(Long id, PessoaFisicaDTO pessoaFisicaDto);
    void deletePessoaFisica(Long id);
    PessoaFisicaDTO getPessoaFisicaByCpf(String cpf);
    List<PessoaFisicaDTO> findByNomeContaining(String nome);
}

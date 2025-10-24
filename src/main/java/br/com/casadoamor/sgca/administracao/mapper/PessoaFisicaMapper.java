package br.com.casadoamor.sgca.administracao.mapper;

import br.com.casadoamor.sgca.administracao.dto.EnderecoDTO;
import br.com.casadoamor.sgca.administracao.dto.PessoaFisicaDTO;
import br.com.casadoamor.sgca.administracao.entity.Endereco;
import br.com.casadoamor.sgca.administracao.entity.PessoaFisica;

public class PessoaFisicaMapper {

    public static PessoaFisicaDTO toPessoaFisicaDto(PessoaFisica pessoaFisica) {
        return new PessoaFisicaDTO(
                pessoaFisica.getId(),
                pessoaFisica.getNome(),
                pessoaFisica.getDataNascimento(),
                pessoaFisica.getCpf(),
                pessoaFisica.getRg(),
                pessoaFisica.getNaturalidade(),
                pessoaFisica.getProfissao(),
                pessoaFisica.getTelefone(),
                pessoaFisica.getEmail(),
                toEnderecoDto(pessoaFisica.getEndereco())
        );
    }

    public static PessoaFisica toPessoaFisica(PessoaFisicaDTO pessoaFisicaDto) {
        return new PessoaFisica(
                pessoaFisicaDto.getId(),
                pessoaFisicaDto.getNome(),
                pessoaFisicaDto.getDataNascimento(),
                pessoaFisicaDto.getCpf(),
                pessoaFisicaDto.getRg(),
                pessoaFisicaDto.getNaturalidade(),
                pessoaFisicaDto.getProfissao(),
                pessoaFisicaDto.getTelefone(),
                pessoaFisicaDto.getEmail(),
                toEndereco(pessoaFisicaDto.getEndereco())
        );
    }

    public static EnderecoDTO toEnderecoDto(Endereco endereco) {
        return new EnderecoDTO(
                endereco.getEndereco(),
                endereco.getBairro(),
                endereco.getNumero(),
                endereco.getCidade(),
                endereco.getEstado(),
                endereco.getCep(),
                endereco.getComplemento()
        );
    }

    public static Endereco toEndereco(EnderecoDTO endereco) {
        return new Endereco(
                endereco.getEndereco(),
                endereco.getBairro(),
                endereco.getNumero(),
                endereco.getCidade(),
                endereco.getEstado(),
                endereco.getCep(),
                endereco.getComplemento()
        );
    }
}

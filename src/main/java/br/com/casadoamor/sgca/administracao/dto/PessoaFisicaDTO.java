package br.com.casadoamor.sgca.administracao.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PessoaFisicaDTO {

    private Long id;
    private String nome;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date dataNascimento;
    private String cpf;
    private String rg;
    private String naturalidade;
    private String profissao;
    private String telefone;
    private String email;
    private EnderecoDTO endereco;
}

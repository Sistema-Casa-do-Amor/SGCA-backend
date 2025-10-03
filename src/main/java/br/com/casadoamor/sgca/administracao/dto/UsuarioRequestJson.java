package br.com.casadoamor.sgca.administracao.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioRequestJson {
    private Long id;
    private String cpf;
    private String senha;
    private boolean ativo = true;
    private Long pessoaFisica;
}

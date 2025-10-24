package br.com.casadoamor.sgca.administracao.dto;

import br.com.casadoamor.sgca.administracao.entity.TipoDocumentoProfissionalSaudeEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProfissionalSaudeDTO {

    private Long id;
    private TipoDocumentoProfissionalSaudeEnum tipo;
    private String documento;
    private String ufDocumento;
    private String especialidade;
    private PessoaFisicaDTO pessoaFisica;
}


package br.com.casadoamor.sgca.prontuario.model;

import br.com.casadoamor.sgca.prontuario.entity.OpcaoResposta;
import br.com.casadoamor.sgca.prontuario.utils.ProfissionalSaudeEnum;
import br.com.casadoamor.sgca.prontuario.utils.TipoPerguntaEnum;
import br.com.casadoamor.sgca.prontuario.utils.TipoQuestionarioEnum;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class PerguntaDTO {

    private Long id;

    @NotBlank
    private String texto;

    @NotNull
    private ProfissionalSaudeEnum tipoProfissional;

    @NotNull
    private TipoQuestionarioEnum tipoQuestionario;

    @NotNull
    private TipoPerguntaEnum tipoPergunta;

    private List<OpcaoResposta> opcoes = new ArrayList<>();

    @NotNull
    private Integer ordemPrioridade = Integer.MAX_VALUE;

    private boolean deleted = false;
}
package br.com.casadoamor.sgca.prontuario.model;

import br.com.casadoamor.sgca.prontuario.entity.Resposta;
import br.com.casadoamor.sgca.prontuario.utils.ProfissionalSaudeEnum;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class EvolucaoDTO {

    private Long id;

    @NotNull
    private ProntuarioDTO prontuario;

    private Date dataAbertura;

    private Date dataFechamento;

    @NotNull
    private ProfissionalSaudeEnum categoriaRegistro;

    private List<RespostaDTO> respostas = new ArrayList<>();
}
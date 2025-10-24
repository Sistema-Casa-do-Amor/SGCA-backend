package br.com.casadoamor.sgca.prontuario.model;

import br.com.casadoamor.sgca.prontuario.entity.Pergunta;
import br.com.casadoamor.sgca.prontuario.entity.RegistroClinico;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class RespostaDTO {

    private Long id;

    @NotNull
    private Pergunta pergunta;

    @NotBlank
    private String resposta;

    @NotNull
    private RegistroClinico registroClinico;
}

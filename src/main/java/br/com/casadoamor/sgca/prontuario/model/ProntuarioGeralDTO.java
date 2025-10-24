package br.com.casadoamor.sgca.prontuario.model;

import br.com.casadoamor.sgca.administracao.dto.PessoaFisicaDTO;
import br.com.casadoamor.sgca.prontuario.entity.Resposta;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ProntuarioGeralDTO {

    private Long os;

    private Date dataChegada;

    private Date dataSaida;

    private String motivoSaida;

    @NotNull
    private PessoaFisicaDTO paciente;

    private List<ProntuarioDTO> prontuarios = new ArrayList<>();

    private List<RespostaDTO> respostas = new ArrayList<>();

}
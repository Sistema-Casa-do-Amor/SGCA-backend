package br.com.casadoamor.sgca.prontuario.entity;

import br.com.casadoamor.sgca.prontuario.utils.ProfissionalSaudeEnum;
import br.com.casadoamor.sgca.prontuario.utils.TipoPerguntaEnum;
import br.com.casadoamor.sgca.prontuario.utils.TipoQuestionarioEnum;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Pergunta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(unique = true)
    private String texto;

    @Enumerated(EnumType.STRING)
    private ProfissionalSaudeEnum tipoProfissional;

    @Enumerated(EnumType.STRING)
    private TipoQuestionarioEnum tipoQuestionario;

    @Enumerated(EnumType.STRING)
    private TipoPerguntaEnum tipoPergunta;

    @OneToMany(mappedBy = "perguntas", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OpcaoResposta> opcoes = new ArrayList<>();

    private Integer ordemPrioridade = Integer.MAX_VALUE;

    private boolean deleted = false;    // soft delete
}
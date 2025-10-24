package br.com.casadoamor.sgca.prontuario.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class OpcaoResposta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String texto;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, optional = false)
    private Pergunta pergunta;
}

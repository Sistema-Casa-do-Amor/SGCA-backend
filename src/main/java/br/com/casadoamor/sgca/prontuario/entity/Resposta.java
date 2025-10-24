package br.com.casadoamor.sgca.prontuario.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Resposta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne( optional = false )
    private Pergunta pergunta;

    private String resposta;

    @ManyToOne( fetch = FetchType.LAZY, optional = false )
    private RegistroClinico registroClinico;
}

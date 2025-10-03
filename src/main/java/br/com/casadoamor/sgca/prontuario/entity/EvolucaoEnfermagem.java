package br.com.casadoamor.sgca.prontuario.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "evolucao_enf")
public class EvolucaoEnfermagem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "pront_enfermagem_id")
    private ProntuarioEnfermagem prontuarioEnfermagem;

    private Date dataAbertura;

    private Date dataFechamento;
}

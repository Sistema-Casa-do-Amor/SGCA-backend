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
@Table(name = "pront_enf")
public class ProntuarioEnfermagem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(optional = false)
    @JoinColumn(name = "pront_geral_os")
    private ProntuarioGeral prontuarioGeral;

    private Date dataAbertura;

    private Date dataFechamento;
}

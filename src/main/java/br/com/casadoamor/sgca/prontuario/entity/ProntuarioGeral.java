package br.com.casadoamor.sgca.prontuario.entity;

import br.com.casadoamor.sgca.administracao.entity.PessoaFisica;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "pront_geral")
public class ProntuarioGeral {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long os;

    private Date dataChegada;

    private Date dataSaida;

    private String motivoSaida;

    @OneToOne
    @JoinColumn(name = "paciente_id")
    private PessoaFisica paciente;

}

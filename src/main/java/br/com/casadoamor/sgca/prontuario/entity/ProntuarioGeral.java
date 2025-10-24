package br.com.casadoamor.sgca.prontuario.entity;

import br.com.casadoamor.sgca.administracao.entity.PessoaFisica;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
public class ProntuarioGeral extends RegistroClinico {

    private Date dataChegada;

    private Date dataSaida;

    private String motivoSaida;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "paciente_id",  nullable = false)
    private PessoaFisica paciente;

    @OneToMany(mappedBy = "prontuarioGeral", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Prontuario> prontuarios = new ArrayList<>();
}

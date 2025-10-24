package br.com.casadoamor.sgca.prontuario.entity;

import br.com.casadoamor.sgca.prontuario.utils.ProfissionalSaudeEnum;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
public class Prontuario extends RegistroClinico {

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private ProntuarioGeral prontuarioGeral;

    private Date dataAbertura;

    private Date dataFechamento;

    @Enumerated(EnumType.STRING)
    private ProfissionalSaudeEnum categoriaRegistro;

    @OneToMany(mappedBy = "prontuario", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Evolucao> evolucao = new ArrayList<>();
}

package br.com.casadoamor.sgca.prontuario.entity;

import br.com.casadoamor.sgca.prontuario.utils.ProfissionalSaudeEnum;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
public class Evolucao extends RegistroClinico {

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Prontuario prontuario;

    private Date dataAbertura;

    private Date dataFechamento;

    @Enumerated(EnumType.STRING)
    private ProfissionalSaudeEnum categoriaRegistro;
}

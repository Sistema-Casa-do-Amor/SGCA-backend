package br.com.casadoamor.sgca.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "profissional_saude")
public class ProfissionalSaude {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private TipoDocumentoProfissionalSaudeEnum tipo;
    private String documento;
    @Column(length = 2)
    private String ufDocumento;
    private String especialidade;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "pessoa_fisica_id",  nullable = false)
    private PessoaFisica pessoaFisica;
}

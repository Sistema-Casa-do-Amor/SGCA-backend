package br.com.casadoamor.sgca.prontuario.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn
public abstract class RegistroClinico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany( mappedBy = "registroClinico",cascade = CascadeType.ALL, orphanRemoval = true )
    private List<Resposta> respostas = new ArrayList<>();
}

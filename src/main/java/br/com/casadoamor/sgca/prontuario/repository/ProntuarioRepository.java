package br.com.casadoamor.sgca.prontuario.repository;

import br.com.casadoamor.sgca.prontuario.entity.Prontuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProntuarioRepository extends JpaRepository<Prontuario, Long> {
}

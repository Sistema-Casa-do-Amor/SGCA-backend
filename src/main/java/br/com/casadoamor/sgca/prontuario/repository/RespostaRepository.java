package br.com.casadoamor.sgca.prontuario.repository;

import br.com.casadoamor.sgca.prontuario.entity.Resposta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RespostaRepository extends JpaRepository<Resposta, Long> {
    List<Resposta> findByRegistroClinico_Id(Long id);
}

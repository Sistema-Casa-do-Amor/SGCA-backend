package br.com.casadoamor.sgca.prontuario.repository;

import br.com.casadoamor.sgca.prontuario.entity.Pergunta;
import org.hibernate.annotations.SoftDelete;
import org.springframework.data.jpa.repository.JpaRepository;

@SoftDelete(columnName = "deleted")
public interface PerguntaRepository extends JpaRepository<Pergunta, Long> {
}

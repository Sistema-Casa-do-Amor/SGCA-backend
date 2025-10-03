package br.com.casadoamor.sgca.administracao.repository;

import br.com.casadoamor.sgca.administracao.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByCpf(String cpf);
}

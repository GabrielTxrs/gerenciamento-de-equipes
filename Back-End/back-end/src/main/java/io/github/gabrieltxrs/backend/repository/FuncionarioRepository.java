package io.github.gabrieltxrs.backend.repository;

import io.github.gabrieltxrs.backend.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

}

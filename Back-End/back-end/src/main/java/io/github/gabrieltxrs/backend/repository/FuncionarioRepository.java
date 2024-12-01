package io.github.gabrieltxrs.backend.repository;

import io.github.gabrieltxrs.backend.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

    Boolean findByEmailAndSenha(String email, String senha);
    Funcionario cadastrarFuncionario(Funcionario funcionario);
    Funcionario getFuncionarioPorId(Long id);

}

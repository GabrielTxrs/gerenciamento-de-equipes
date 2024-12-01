package io.github.gabrieltxrs.backend.repository;

import io.github.gabrieltxrs.backend.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

    @Query("SELECT CASE WHEN COUNT(f) > 0 THEN true ELSE false END FROM Funcionario f WHERE f.email = :email AND f.senha = :senha")
    Boolean findByEmailAndSenha(String email, String senha);

}

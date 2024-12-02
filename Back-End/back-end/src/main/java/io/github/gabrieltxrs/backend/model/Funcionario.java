package io.github.gabrieltxrs.backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Funcionario {
    @Id
    private Long   idFuncionario;
    private String nome;
    private String cargo;
    private String cpf;
    private String email;
    private String senha;

    public Funcionario() {
        // Construtor padrão do Jackson
    }

    public Funcionario(Long idFuncionario, String nome, String cargo, String email, String senha) {
        this.idFuncionario = idFuncionario;
        this.nome = nome;
        this.cargo = cargo;
        this.email = email;
        this.senha = senha;
    }
}

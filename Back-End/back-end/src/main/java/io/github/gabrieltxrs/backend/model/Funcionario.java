package io.github.gabrieltxrs.backend.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Funcionario {
    @Id
    @SequenceGenerator(name = "funcionario_sequence",
            sequenceName = "funcionario_sequence",
            allocationSize = 1)
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "funcionario_sequence"
    )
    private Long idFuncionario;
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

package io.github.gabrieltxrs.backend.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Getter
@Setter
public class Funcionario implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long   idFuncionario;
    private String nome;
    @Enumerated(EnumType.STRING)
    private Cargo cargo;
    private String cpf;
    private String email;
    private String senha;
    @ManyToOne
    @JoinColumn(name = "id_obra")// Relacionamento com a obra
    private Obra obra; // Obra em que o funcionário está alocado
    public Funcionario() {

        // Construtor padrão do Jackson
    }


    public Funcionario( String nome, Cargo cargo, String email, String senha, Obra obra) {
        this.nome = nome;
        this.cargo = cargo;
        this.email = email;
        this.senha = senha;
        this.obra = obra;
    }
}

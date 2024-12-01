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
    private Long id;
    private String noma;
    private String cargo;
    private String email;
    private String senha;

    public Funcionario() {
        // Construtor padrão do Jackson
    }

    public Funcionario(Long id, String noma, String cargo, String email, String senha) {
        this.id = id;
        this.noma = noma;
        this.cargo = cargo;
        this.email = email;
        this.senha = senha;
    }
}

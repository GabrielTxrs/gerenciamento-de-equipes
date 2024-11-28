package io.github.gabrieltxrs.backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Funcionario {
    @Id
    private Long id;
    private String noma;
    private String cargo;
    private String email;
    private String senha;
}

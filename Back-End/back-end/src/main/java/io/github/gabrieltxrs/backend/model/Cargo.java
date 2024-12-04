package io.github.gabrieltxrs.backend.model;

import lombok.ToString;

@ToString
public enum Cargo {
    FUNCIONARIO("Funcionario"),
    GERENTE_LOCAL("Gerente_Local"),
    GERENTE_GLOBAL("Gerente_Global");

    private final String nomeCargo;

    Cargo(String nomeCargo) {
        this.nomeCargo = nomeCargo;
    }

    public String getNomeCargo() {
        return nomeCargo;
    }
}

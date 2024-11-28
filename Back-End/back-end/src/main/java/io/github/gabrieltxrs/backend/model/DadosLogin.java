package io.github.gabrieltxrs.backend.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Getter;

@Getter
public class DadosLogin {
    private String email;
    private String senha;

    public DadosLogin(String email, String senha) {
        this.email = email;
        this.senha = senha;
    }
}

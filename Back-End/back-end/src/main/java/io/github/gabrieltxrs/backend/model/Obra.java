package io.github.gabrieltxrs.backend.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Obra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idObra;

    private String status;

    @OneToMany(mappedBy = "obra") // Relacionamento de um-para-muitos (uma obra, vários funcionários)
    private List<Funcionario> funcionariosAlocados; // Funcionários alocados à obra

    private Funcionario gerente;

    // Método para obter o gerente da obra
    public Funcionario getGerente() {
        if(funcionariosAlocados==null){
            return null;
        }

        for (Funcionario func : funcionariosAlocados) {
            if (Cargo.GERENTE_LOCAL.equals(func.getCargo())) {
                return func;
            }
        }
        return null; // Caso não haja gerente alocado
    }
    public Obra(){

    }

    public Obra(String status) {

        this.status = status;
        this.gerente = getGerente();
    }
}



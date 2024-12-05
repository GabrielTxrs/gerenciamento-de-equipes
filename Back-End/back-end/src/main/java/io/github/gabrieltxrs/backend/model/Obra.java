package io.github.gabrieltxrs.backend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Obra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idObra;

    private String status;

    @OneToMany(mappedBy = "obra",cascade = CascadeType.PERSIST) // Relacionamento de um-para-muitos (uma obra, vários funcionários)
    @JsonIgnore
    private List<Funcionario> funcionariosAlocados; // Funcionários alocados à obra

    private LocalDate dataInicio;

    private LocalDate dataFim;



    public Obra(){

    }

    public Obra(String status) {

        this.status = status;
    }
}



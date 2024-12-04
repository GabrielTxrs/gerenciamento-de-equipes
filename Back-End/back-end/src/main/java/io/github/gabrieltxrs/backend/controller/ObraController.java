package io.github.gabrieltxrs.backend.controller;

import io.github.gabrieltxrs.backend.model.Obra;
import io.github.gabrieltxrs.backend.service.ObraService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/obra")
public class ObraController {

    private ObraService obraService;

    public ObraController(ObraService obraService){
        this.obraService = obraService;
    }

    @PostMapping
    public ResponseEntity<Obra> salvarObra(@RequestBody Obra obra){
        try {
            return new ResponseEntity<Obra>(obraService.criarObra(obra), HttpStatus.CREATED);
        } catch (Exception e) {
            throw new RuntimeException("Erro interno ao criar a obra: " + e.getMessage());
        }

    }
}

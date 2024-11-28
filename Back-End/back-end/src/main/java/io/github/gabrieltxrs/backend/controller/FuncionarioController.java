package io.github.gabrieltxrs.backend.controller;

import io.github.gabrieltxrs.backend.model.DadosLogin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.github.gabrieltxrs.backend.service.FuncionarioService;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {
    private final FuncionarioService funcionarioService;

    public FuncionarioController(FuncionarioService funcionarioService) {
        this.funcionarioService = funcionarioService;
    }

    @PostMapping("/login")
    public String loginFuncionario(
            @RequestBody DadosLogin dadosLogin) {
        System.out.println(dadosLogin.getEmail());
        System.out.println(dadosLogin.getSenha());

//        System.out.println("Chegou no controller");
        return "{\"token\": \"autorizado\"}";
//        return funcionarioService.loginFuncioanrio(dadosLogin);

    }
}

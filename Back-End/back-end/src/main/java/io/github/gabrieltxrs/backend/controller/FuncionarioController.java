package io.github.gabrieltxrs.backend.controller;

import io.github.gabrieltxrs.backend.model.DadosLogin;
import io.github.gabrieltxrs.backend.model.Funcionario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.github.gabrieltxrs.backend.service.FuncionarioService;

import java.util.List;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {
    private final FuncionarioService funcionarioService;

    @Autowired
    public FuncionarioController(FuncionarioService funcionarioService) {
        this.funcionarioService = funcionarioService;
    }

    @PostMapping("/login")
    public String loginFuncionario(
            @RequestBody DadosLogin dadosLogin) {
        return funcionarioService.loginFuncionario(dadosLogin);
    }

    @PostMapping("/cadastro")
    public Funcionario cadastrarFuncionario(
            @RequestBody Funcionario funcionario) {
        return funcionarioService.cadastrarFuncionario(funcionario);
    }

    @GetMapping("/get")
    public List<Funcionario> getAllFuncionarios() {
        return funcionarioService.getAllFuncionarios();
    }
    @GetMapping("/get/{id}")
    public Funcionario getFuncionarioPorId(
            @PathVariable Long id) {
        return funcionarioService.getFuncionarioPorId(id);
    }
    @DeleteMapping("/delete/{id}")
    public void deletarFuncionario(
            @PathVariable Long id) {
        funcionarioService.deletarFuncionario(id);
    }

}

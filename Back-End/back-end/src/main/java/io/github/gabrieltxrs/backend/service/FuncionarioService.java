package io.github.gabrieltxrs.backend.service;

import io.github.gabrieltxrs.backend.model.DadosLogin;
import io.github.gabrieltxrs.backend.model.Funcionario;
import org.springframework.stereotype.Service;
import io.github.gabrieltxrs.backend.repository.FuncionarioRepository;

@Service
public class FuncionarioService {
    private final FuncionarioRepository funcionarioRepository;

    public FuncionarioService(FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }

    public String loginFuncionario(DadosLogin dadosLogin) {
        if(funcionarioRepository.findByEmailAndSenha(dadosLogin.getEmail(), dadosLogin.getSenha())) {
            return "Login efetuado com sucesso!";
        }
        return "Email ou senha incorretos!";
    }

    public Funcionario cadastrarFuncionario(Funcionario funcionario) {
        return funcionarioRepository.save(funcionario);
    }

    public Funcionario getFuncionarioPorId(Long id) {
        return funcionarioRepository.findById(id).orElse(null);
    }

    public void deletarFuncionario(Long id) {
        funcionarioRepository.deleteById(id);
    }

    public Funcionario atualizarFuncionario(Funcionario funcionario) {
        return funcionarioRepository.save(funcionario);
    }

}

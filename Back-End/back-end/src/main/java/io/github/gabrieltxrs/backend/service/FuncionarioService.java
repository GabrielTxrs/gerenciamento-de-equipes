package io.github.gabrieltxrs.backend.service;

import io.github.gabrieltxrs.backend.model.DadosLogin;
import io.github.gabrieltxrs.backend.model.Funcionario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import io.github.gabrieltxrs.backend.repository.FuncionarioRepository;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class FuncionarioService {
    private final FuncionarioRepository funcionarioRepository;

    @Autowired
    public FuncionarioService(FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }

    public String loginFuncionario(DadosLogin dadosLogin) {
        if(funcionarioRepository.findByEmailAndSenha(dadosLogin.getEmail(), dadosLogin.getSenha())) {
            return "{\"tokem\": \"autorizado\"}";
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não Cadastrado.");
    }

    public Funcionario cadastrarFuncionario(Funcionario funcionario) {
        return funcionarioRepository.save(funcionario);
    }

    public Funcionario getFuncionarioPorId(Long id) {
        return funcionarioRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Funcionário não encontrado."));
    }

//    public void deletarFuncionario(Long id) {
//        funcionarioRepository.deleteById(id);
//    }

//    public Funcionario atualizarFuncionario(Funcionario funcionario) {
//        return funcionarioRepository.save(funcionario);
//    }

}

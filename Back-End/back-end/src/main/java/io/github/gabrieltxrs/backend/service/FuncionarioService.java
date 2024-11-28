package io.github.gabrieltxrs.backend.service;

import io.github.gabrieltxrs.backend.model.Funcionario;
import org.springframework.stereotype.Service;
import io.github.gabrieltxrs.backend.repository.FuncionarioRepository;

@Service
public class FuncionarioService {
    private final FuncionarioRepository funcionarioRepository;

    public FuncionarioService(FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }

    public Funcionario addFuncionario(Funcionario funcionario) {
        return funcionarioRepository.save(funcionario);
    }

}

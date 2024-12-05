package io.github.gabrieltxrs.backend.service;

import io.github.gabrieltxrs.backend.model.Funcionario;
import io.github.gabrieltxrs.backend.model.Obra;
import io.github.gabrieltxrs.backend.repository.ObraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ObraService{
    @Autowired
    private ObraRepository obraRepository;


    public Obra criarObra(Obra obra){
        return obraRepository.save(obra);
    }

    public List<Obra> listarObras(){
        List<Obra> obras = obraRepository.findAll();
        return (obras == null) ? new ArrayList<>(): obras;
    }
    public Obra atualizarObra(Long id, Obra obraAtualizada) {
        if (obraRepository.existsById(id)) {
            obraAtualizada.setIdObra(id);
            return obraRepository.save(obraAtualizada);
        }
        return null;
    }
    public boolean excluirObra(Long id){
        if(obraRepository.existsById(id)){
            obraRepository.deleteById(id);
            return true;
        }
        return false;
    }


}

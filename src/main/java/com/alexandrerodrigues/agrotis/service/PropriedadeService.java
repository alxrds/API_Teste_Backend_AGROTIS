package com.alexandrerodrigues.agrotis.service;

import com.alexandrerodrigues.agrotis.repository.PropriedadeRepository;
import com.alexandrerodrigues.agrotis.model.Propriedade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PropriedadeService {

    @Autowired
    private PropriedadeRepository propriedadeRepository;

    public Propriedade salvar(Propriedade propriedade){
        return propriedadeRepository.save(propriedade);
    }

    public List<Propriedade> listaPropriedade(){
        return propriedadeRepository.findAll();
    }

    public Optional<Propriedade> buscarPorId(Long id){
        return propriedadeRepository.findById(id);
    }

    public void removerPorId(Long id){
        propriedadeRepository.deleteById(id);
    }
}

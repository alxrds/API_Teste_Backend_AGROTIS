package com.alexandrerodrigues.agrotis.service;

import com.alexandrerodrigues.agrotis.model.Laboratorio;
import com.alexandrerodrigues.agrotis.repository.LaboratorioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LaboratorioService {

    @Autowired
    private LaboratorioRepository laboratorioRepository;

    public Laboratorio salvar(Laboratorio laboratorio){
        return laboratorioRepository.save(laboratorio);
    }

    public List<Laboratorio> listaLaboratorio(){
        return laboratorioRepository.findAll();
    }

    public Optional<Laboratorio> buscarPorId(Long id){
        return laboratorioRepository.findById(id);
    }

    public void removerPorId(Long id){
        laboratorioRepository.deleteById(id);
    }
}


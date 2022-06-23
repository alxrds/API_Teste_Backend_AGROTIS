package com.alexandrerodrigues.agrotis.controller;

import com.alexandrerodrigues.agrotis.model.Laboratorio;
import com.alexandrerodrigues.agrotis.service.LaboratorioService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/laboratorio")
public class LaboratorioController {

    @Autowired
    private LaboratorioService laboratorioService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Laboratorio salvar(@RequestBody Laboratorio laboratorio){
        return laboratorioService.salvar(laboratorio);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Laboratorio> listaLaboratorio(){
        return laboratorioService.listaLaboratorio();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Laboratorio buscaLaboratorioPorId(@PathVariable Long id){
        return laboratorioService.buscarPorId(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizarLaboratorioe(@PathVariable Long id, @RequestBody Laboratorio laboratorio){
        laboratorioService.buscarPorId(id)
                .map(laboratorioBase -> {
                    modelMapper.map(laboratorio, laboratorioBase);
                    laboratorioService.salvar(laboratorioBase);
                    return Void.TYPE;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removerLaboratorio(@PathVariable Long id){
        laboratorioService.buscarPorId(id)
                .map(laboratorio -> {
                    laboratorioService.removerPorId(laboratorio.getId());
                    return Void.TYPE;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

}


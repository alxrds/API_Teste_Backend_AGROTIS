package com.alexandrerodrigues.agrotis.controller;

import com.alexandrerodrigues.agrotis.model.Propriedade;
import com.alexandrerodrigues.agrotis.service.PropriedadeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/propriedade")
public class PropriedadeController {

    @Autowired
    private PropriedadeService propriedadeService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Propriedade salvar(@RequestBody Propriedade propriedade){
        return propriedadeService.salvar(propriedade);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Propriedade> listaPropriedade(){
        return propriedadeService.listaPropriedade();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Propriedade buscaPropriedadePorId(@PathVariable Long id){
        return propriedadeService.buscarPorId(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizarPropriedade(@PathVariable Long id, @RequestBody Propriedade propriedade){
        propriedadeService.buscarPorId(id)
                .map(propriedadeBase -> {
                    modelMapper.map(propriedade, propriedadeBase);
                    propriedadeService.salvar(propriedadeBase);
                    return Void.TYPE;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removerPropriedade(@PathVariable Long id){
        propriedadeService.buscarPorId(id)
                .map(propriedade -> {
                    propriedadeService.removerPorId(propriedade.getId());
                    return Void.TYPE;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

}


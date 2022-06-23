package com.alexandrerodrigues.agrotis.repository;

import com.alexandrerodrigues.agrotis.model.Laboratorio;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@TestMethodOrder(MethodOrderer.DisplayName.class)
class LaboratorioRepositoryTest {

    @Autowired
    LaboratorioRepository laboratorioRepository;

    @DisplayName("1 - Criou Laboratório")
    @Test
    void deveCriarLaboratorio(){
        Laboratorio laboratorio = new Laboratorio();
        laboratorio.setNome("Teste de Laboratório");
        laboratorioRepository.save(laboratorio);
    }

    @DisplayName("2 - Listou Laboratórios")
    @Test
    void deveListarLaboratorios(){
        List<Laboratorio> list = laboratorioRepository.findAll();
        assertThat(list).size().isGreaterThan(0);
    }

    @DisplayName("3 - Listou Laboratório por Id")
    @Test
    void deveListarLaboratorioPorId(){
        Laboratorio laboratorio = laboratorioRepository.findById(1L).get();
        assertEquals("Teste de Laboratório", laboratorio.getNome());
    }

    @DisplayName("4 - Alterou nome do Laboratório")
    @Test
    void deveAlterarLaboratorio(){
        Laboratorio laboratorio = laboratorioRepository.findById(1L).get();
        laboratorio.setNome("Teste de Laboratório 2");
        laboratorioRepository.save(laboratorio);
        assertEquals("Teste de Laboratório 2", laboratorio.getNome());
    }

    @DisplayName("5 - Excluiu Laboratório")
    @Test
    void deveExcluirLaboratorio(){
        laboratorioRepository.deleteById(1L);
        assertThat(laboratorioRepository.existsById(1L));
    }

}
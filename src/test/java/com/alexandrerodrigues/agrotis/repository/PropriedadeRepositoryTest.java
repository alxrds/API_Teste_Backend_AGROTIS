package com.alexandrerodrigues.agrotis.repository;

import com.alexandrerodrigues.agrotis.model.Propriedade;
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
class PropriedadeRepositoryTest {

    @Autowired
    PropriedadeRepository propriedadeRepository;

    @DisplayName("1 - Criou Propriedade")
    @Test
    void deveCriarPropriedade(){
        Propriedade propriedade = new Propriedade();
        propriedade.setNome("Teste de Propriedade");
        propriedade.setCnpj("XX.XXX.XXX/0001-XX");
        propriedadeRepository.save(propriedade);
    }

    @DisplayName("2 - Listou Propriedades")
    @Test
    void deveListarPropriedades(){
        List<Propriedade> list = propriedadeRepository.findAll();
        assertThat(list).size().isGreaterThan(0);
    }

    @DisplayName("3 - Listou Propriedade por Id")
    @Test
    void deveListarPropriedadePorId(){
        Propriedade propriedade = propriedadeRepository.findById(1L).get();
        assertEquals("Teste de Propriedade", propriedade.getNome());
    }

    @DisplayName("4 - Alterou nome do Propriedade")
    @Test
    void deveAlterarLaboratorio(){
        Propriedade propriedade = propriedadeRepository.findById(1L).get();
        propriedade.setNome("Teste de Propriedade 2");
        propriedadeRepository.save(propriedade);
        assertEquals("Teste de Propriedade 2", propriedade.getNome());
    }

    @DisplayName("5 - Excluiu Propriedade")
    @Test
    void deveExcluirPropriedade(){
        propriedadeRepository.deleteById(1L);
        assertThat(propriedadeRepository.existsById(1L));
    }

}
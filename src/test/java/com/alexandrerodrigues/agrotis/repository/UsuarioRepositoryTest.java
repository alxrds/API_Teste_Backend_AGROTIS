package com.alexandrerodrigues.agrotis.repository;

import com.alexandrerodrigues.agrotis.model.Laboratorio;
import com.alexandrerodrigues.agrotis.model.Propriedade;
import com.alexandrerodrigues.agrotis.model.Usuario;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@TestMethodOrder(MethodOrderer.DisplayName.class)
class UsuarioRepositoryTest {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    PropriedadeRepository propriedadeRepository;

    @Autowired
    LaboratorioRepository laboratorioRepository;

    @DisplayName("1 - Criou Propriedade")
    @Test
    void deveCriarPropriedade() {
        Propriedade propriedade = new Propriedade();
        propriedade.setNome("Teste de Propriedade");
        propriedade.setCnpj("XX.XXX.XXX/0001-XX");
        propriedadeRepository.save(propriedade);
    }

    @DisplayName("2 - Criou Laboratório")
    @Test
    void deveCriarLaboratorio() {
        Laboratorio laboratorio = new Laboratorio();
        laboratorio.setNome("Teste de Laboratório");
        laboratorioRepository.save(laboratorio);
    }

    @DisplayName("3 - Criou Usuario")
    @Test
    void deveCriarUsuario() {
        Date data = new Date();
        Usuario usuario = new Usuario();
        usuario.setNome("Jon Doe");
        usuario.setDataInicial(data);
        usuario.setDataFinal(data);
        usuario.setObservacoes("Observacao exemplo de teste");
        usuarioRepository.save(usuario);
    }

    @DisplayName("4 - Listou Usuários")
    @Test
    void deveListarUsuários() {
        List<Usuario> list = usuarioRepository.findAll();
        assertThat(list).size().isGreaterThan(0);
    }

    @DisplayName("5 - Listou Usuario por Id")
    @Test
    void deveListarPropriedadePorId() {
        Usuario usuario = usuarioRepository.findById(1L).get();
        assertEquals("Jon Doe", usuario.getNome());
    }

    @DisplayName("6 - Alterou nome do Usuário")
    @Test
    void deveAlterarUsuario() {
        Usuario usuario = usuarioRepository.findById(1L).get();
        usuario.setNome("Jon Doe 2");
        usuarioRepository.save(usuario);
        assertEquals("Jon Doe 2", usuario.getNome());
    }

    @DisplayName("7 - Excluiu Usuário")
    @Test
    void deveExcluirUsuario() {
        usuarioRepository.deleteById(1L);
        assertThat(usuarioRepository.existsById(1L));
    }

}
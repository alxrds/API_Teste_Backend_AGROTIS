package com.alexandrerodrigues.agrotis.repository;

import com.alexandrerodrigues.agrotis.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}

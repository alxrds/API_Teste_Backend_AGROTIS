package com.alexandrerodrigues.agrotis.repository;

import com.alexandrerodrigues.agrotis.model.Propriedade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PropriedadeRepository extends JpaRepository<Propriedade, Long> {
}
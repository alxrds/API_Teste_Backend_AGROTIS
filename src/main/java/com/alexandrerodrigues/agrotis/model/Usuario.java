package com.alexandrerodrigues.agrotis.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name="nome", nullable = false)
    private String nome;

    @Column(name="dataInicial", nullable = false)
    private Date dataInicial;

    @Column(name="dataFinal", nullable = false)
    private Date dataFinal;

    @ManyToOne @JoinColumn(name = "propriedade_id")
    private Propriedade infosPropriedade;

    @ManyToOne @JoinColumn(name = "laboratorio_id")
    private Laboratorio laboratorio;

    @Column(name="observacoes")
    private String observacoes;

    public void setInfosPropriedade() {
    }
}

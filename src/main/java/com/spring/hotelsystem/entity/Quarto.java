package com.spring.hotelsystem.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
public class Quarto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal valorDiaria;
    private boolean disponivel;

    public Long getId() {
        return id;
    }

    public BigDecimal getValorDiaria() {
        return valorDiaria;
    }

    public void setValorDiaria(BigDecimal valorDiaria) {
        this.valorDiaria = valorDiaria;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel() {
        this.disponivel = disponivel;
    }
}
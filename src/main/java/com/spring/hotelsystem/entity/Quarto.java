package com.spring.hotelsystem.entity;

import jakarta.persistence.*;
import org.springframework.data.annotation.Id;

import java.math.BigDecimal;

@Entity
public class Quarto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String numero;

    @Enumerated(EnumType.STRING)
    private TipoQuarto tipo;

    private BigDecimal valorDiaria;

    private boolean disponivel = true;
}

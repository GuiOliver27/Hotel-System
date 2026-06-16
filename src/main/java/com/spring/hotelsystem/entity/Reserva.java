package com.spring.hotelsystem.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToOne;
import org.springframework.data.annotation.Id;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Hospede hospede;

    @ManyToOne
    private Quarto quarto;

    private LocalDate dataEntrada;
    private LocalDate dataSaida;

    public void setValorTotal(BigDecimal valorTotal) {
    }

    public void setQuarto(Quarto quarto) {
    }
}

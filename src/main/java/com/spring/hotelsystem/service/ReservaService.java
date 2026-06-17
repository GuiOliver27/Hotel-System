package com.spring.hotelsystem.service;

import com.spring.hotelsystem.entity.Hospede;
import com.spring.hotelsystem.entity.Quarto;
import com.spring.hotelsystem.entity.Reserva;
import com.spring.hotelsystem.entity.StatusReserva;
import com.spring.hotelsystem.repository.HospedeRepository;
import com.spring.hotelsystem.repository.QuartoRepository;
import com.spring.hotelsystem.repository.ReservaRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Service
public class ReservaService {

    private final ReservaRepository reservaRepository;
    private final HospedeRepository hospedeRepository;
    private final QuartoRepository quartoRepository;

    public ReservaService(
            ReservaRepository reservaRepository,
            HospedeRepository hospedeRepository,
            QuartoRepository quartoRepository
    ) {
        this.reservaRepository = reservaRepository;
        this.hospedeRepository = hospedeRepository;
        this.quartoRepository = quartoRepository;
    }

    public Reserva criarReserva(Long hospedeId, Long quartoId, LocalDate entrada, LocalDate saida) {
        Hospede hospede = hospedeRepository.findById(hospedeId)
                .orElseThrow(() -> new RuntimeException("Hóspede não encontrado"));

        Quarto quarto = quartoRepository.findById(quartoId)
                .orElseThrow(() -> new RuntimeException("Quarto não encontrado"));

        if (!quarto.isDisponivel()) {
            throw new RuntimeException("Quarto indisponível");
        }

        long dias = ChronoUnit.DAYS.between(entrada, saida);

        if (dias <= 0) {
            throw new RuntimeException("Data de saída deve ser maior que data de entrada");
        }

        BigDecimal valorTotal = quarto.getValorDiaria()
                .multiply(BigDecimal.valueOf(dias));

        quarto.setDisponivel();

        Reserva reserva = new Reserva();
        reserva.setHospede(hospede);
        reserva.setQuarto(quarto);
        reserva.setDataEntrada(entrada);
        reserva.setDataSaida(saida);
        reserva.setStatus(StatusReserva.RESERVADA);
        reserva.setValorTotal(valorTotal);

        return reservaRepository.save(reserva);
    }

    public Reserva realizarCheckin(Long reservaId) {
        Reserva reserva = reservaRepository.findById(reservaId)
                .orElseThrow(() -> new RuntimeException("Reserva não encontrada"));

        reserva.setStatus(StatusReserva.CHECKIN_REALIZADO);

        return reservaRepository.save(reserva);
    }

    public Reserva realizarCheckout(Long reservaId) {
        Reserva reserva = reservaRepository.findById(reservaId)
                .orElseThrow(() -> new RuntimeException("Reserva não encontrada"));

        reserva.setStatus(StatusReserva.CHECKOUT_REALIZADO);

        Quarto quarto = reserva.getQuarto();
        quarto.setDisponivel();

        return reservaRepository.save(reserva);
    }
}

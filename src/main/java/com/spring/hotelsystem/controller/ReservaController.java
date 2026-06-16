package com.spring.hotelsystem.controller;

import com.spring.hotelsystem.entity.Reserva;
import com.spring.hotelsystem.repository.ReservaRepository;
import com.spring.hotelsystem.service.ReservaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservas")
public class ReservaController {
    private final ReservaService reservaService;
    private final ReservaRepository reservaRepository;

    public ReservaController(
            ReservaService reservaService,
            ReservaRepository reservaRepository
    ) {
        this.reservaService = reservaService;
        this.reservaRepository = reservaRepository;
    }

    @GetMapping
    public List<Reserva> listar() {
        return reservaRepository.findAll();
    }

    @PostMapping
    public Reserva criar(@RequestBody ReservaRequest request) {
        return reservaService.criarReserva(
                request.hospedeId(),
                request.quartoId(),
                request.dataEntrada(),
                request.dataSaida()
        );
    }

    @PutMapping("/{id}/checkin")
    public Reserva checkin(@PathVariable Long id) {
        return reservaService.realizarCheckin(id);
    }

    @PutMapping("/{id}/checkout")
    public Reserva checkout(@PathVariable Long id) {
        return reservaService.realizarCheckout(id);
    }
}


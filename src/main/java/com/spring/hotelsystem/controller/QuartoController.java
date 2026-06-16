package com.spring.hotelsystem.controller;

import com.spring.hotelsystem.entity.Quarto;
import com.spring.hotelsystem.repository.QuartoRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quartos")
public class QuartoController {
    private final QuartoRepository repository;

    public QuartoController(QuartoRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Quarto> listar() {
        return repository.findAll();
    }

    @PostMapping
    public Quarto cadastrar(@RequestBody Quarto quarto) {
        return repository.save(quarto);
    }
}

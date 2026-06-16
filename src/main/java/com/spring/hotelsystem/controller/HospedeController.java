package com.spring.hotelsystem.controller;

import com.spring.hotelsystem.entity.Hospede;
import com.spring.hotelsystem.repository.HospedeRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hospedes")
public class HospedeController {
    private final HospedeRepository repository;

    public HospedeController(HospedeRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Hospede> listar() {
        return repository.findAll();
    }

    @PostMapping
    public Hospede cadastrar(@RequestBody Hospede hospede) {
        return repository.save(hospede);
    }
}

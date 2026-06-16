package com.spring.hotelsystem.repository;

import com.spring.hotelsystem.entity.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservaRepository extends JpaRepository<Reserva, Long> {
}

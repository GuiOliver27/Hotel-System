package com.spring.hotelsystem.repository;

import com.spring.hotelsystem.entity.Hospede;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HospedeRepository extends JpaRepository<Hospede, Long> {
}

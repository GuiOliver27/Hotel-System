package com.spring.hotelsystem.dto;

import java.time.LocalDate;

public record ReservaRequest(
        Long hospedeId,
        Long quartoId,
        LocalDate dataEntrada,
        LocalDate dataSaida
) {
}

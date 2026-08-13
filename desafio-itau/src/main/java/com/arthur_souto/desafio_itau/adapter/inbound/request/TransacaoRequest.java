package com.arthur_souto.desafio_itau.adapter.inbound.request;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.PastOrPresent;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

public record TransacaoRequest(
        @DecimalMin(message = "O valor deve ser positivo.", value = "0")
        BigDecimal valor,
        @PastOrPresent(message = "A data deve estar no passado.")
        OffsetDateTime dataHora
) {
}

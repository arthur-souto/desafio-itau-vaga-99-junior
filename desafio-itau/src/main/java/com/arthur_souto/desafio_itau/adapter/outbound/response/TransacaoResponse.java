package com.arthur_souto.desafio_itau.adapter.outbound.response;

import org.springframework.http.HttpStatus;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

public record TransacaoResponse(
        HttpStatus codigo,
        String mensagem,
        UUID idTransacao,
        BigDecimal valor,
        OffsetDateTime dataHora
) {
}

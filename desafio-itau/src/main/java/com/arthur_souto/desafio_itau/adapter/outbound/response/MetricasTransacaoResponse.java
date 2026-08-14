package com.arthur_souto.desafio_itau.adapter.outbound.response;

import org.springframework.http.HttpStatus;

import java.math.BigDecimal;

public record MetricasTransacaoResponse(
        HttpStatus codigo,
        String mensagem,
        long count,
        BigDecimal sum,
        BigDecimal avg,
        BigDecimal min,
        BigDecimal max
) {
}

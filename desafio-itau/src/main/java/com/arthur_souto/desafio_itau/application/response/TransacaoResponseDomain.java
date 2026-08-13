package com.arthur_souto.desafio_itau.application.response;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

public record TransacaoResponseDomain(
   UUID idTransacao,
   BigDecimal valor,
   @JsonFormat(shape = JsonFormat.Shape.STRING)
   OffsetDateTime dataHora
) {}

package com.arthur_souto.desafio_itau.application.mapper;

import com.arthur_souto.desafio_itau.adapter.inbound.request.TransacaoRequest;
import com.arthur_souto.desafio_itau.domain.TransacaoDomain;

public class RequestToDomainMapper {

    public static TransacaoDomain requestToDomain(TransacaoRequest req) {
        return new TransacaoDomain(
                req.valor(),
                req.dataHora()
        );
    }
}

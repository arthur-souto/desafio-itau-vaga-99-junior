package com.arthur_souto.desafio_itau.adapter.inbound.mapper;

import com.arthur_souto.desafio_itau.adapter.outbound.response.TransacaoResponse;
import com.arthur_souto.desafio_itau.application.response.TransacaoResponseDomain;
import org.springframework.http.HttpStatus;

public class DomainToResponseMapper {

    public static TransacaoResponse domainToResponse(TransacaoResponseDomain responseDomain) {
        return new TransacaoResponse(
                HttpStatus.CREATED,
                "Transacao salva com sucesso",
                responseDomain.idTransacao(),
                responseDomain.valor(),
                responseDomain.dataHora()
        );
    }
}

package com.arthur_souto.desafio_itau.adapter.inbound.mapper;

import com.arthur_souto.desafio_itau.adapter.outbound.response.MetricasTransacaoResponse;
import com.arthur_souto.desafio_itau.adapter.outbound.response.TransacaoResponse;
import com.arthur_souto.desafio_itau.application.response.TransacaoResponseDomain;
import com.arthur_souto.desafio_itau.domain.MetricasTransacoesResponseDomain;
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

    public static MetricasTransacaoResponse domainToResponse(MetricasTransacoesResponseDomain responseDomain) {
        return new MetricasTransacaoResponse(
                HttpStatus.OK,
                "Metricas Carregadas com sucesso",
                responseDomain.getCount(),
                responseDomain.getSum(),
                responseDomain.getAvg(),
                responseDomain.getMin(),
                responseDomain.getMax()
        );
    }
}

package com.arthur_souto.desafio_itau.application.adapter;

import com.arthur_souto.desafio_itau.application.port.RetornaMetricasTransacoesPort;
import com.arthur_souto.desafio_itau.domain.MetricasTransacoesResponseDomain;
import com.arthur_souto.desafio_itau.domain.TransacaoDomain;
import com.arthur_souto.desafio_itau.infra.port.BancoDeDadosPort;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.OffsetDateTime;
import java.util.Comparator;

public class RetornaMetricasTransacoesAdapter implements RetornaMetricasTransacoesPort {

    private static final Logger log = LoggerFactory.getLogger(RetornaMetricasTransacoesAdapter.class);
    private final BancoDeDadosPort bancoDeDadosPort;

    private final static int TETO_METRICAS_SEGUNDOS = 60;

    public RetornaMetricasTransacoesAdapter(BancoDeDadosPort bancoDeDadosPort) {
        this.bancoDeDadosPort = bancoDeDadosPort;
    }

    @Override
    public MetricasTransacoesResponseDomain retornarMetricas() {

        var ultimoMinuto =  bancoDeDadosPort.findAll("TRANSACAO_TABLE").stream()
                .map(gp -> (TransacaoDomain) gp.getObject())
                .filter(domain -> domain.getDataHora().isAfter(OffsetDateTime.now().minusSeconds(TETO_METRICAS_SEGUNDOS)))
                .map(TransacaoDomain::getValor)
                .toList();

        long count = ultimoMinuto.size();

        if(count <= 0) {
            return new MetricasTransacoesResponseDomain(0L, BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO);
        }

        var sum = ultimoMinuto.stream().reduce(BigDecimal.ZERO, BigDecimal::add);
        var qtd = BigDecimal.valueOf(ultimoMinuto.size());

        var avg = sum.divide(qtd, 2, RoundingMode.HALF_UP);

        var max = ultimoMinuto
                .stream()
                .max(Comparator.naturalOrder())
                .orElse(BigDecimal.ONE);

        var min = ultimoMinuto
                .stream()
                .min(Comparator.naturalOrder())
                .orElse(BigDecimal.ZERO);

        return new MetricasTransacoesResponseDomain(
                count,
                sum,
                avg,
                min,
                max
        );
    }
}

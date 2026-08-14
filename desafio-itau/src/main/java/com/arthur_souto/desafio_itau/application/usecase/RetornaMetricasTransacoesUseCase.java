package com.arthur_souto.desafio_itau.application.usecase;

import com.arthur_souto.desafio_itau.application.port.RetornaMetricasTransacoesPort;
import com.arthur_souto.desafio_itau.domain.MetricasTransacoesResponseDomain;

public class RetornaMetricasTransacoesUseCase {

    private final RetornaMetricasTransacoesPort retornaMetricasTransacoesPort;

    public RetornaMetricasTransacoesUseCase(RetornaMetricasTransacoesPort retornaMetricasTransacoesPort) {
        this.retornaMetricasTransacoesPort = retornaMetricasTransacoesPort;
    }

    public MetricasTransacoesResponseDomain retornarMetricas() {
        return this.retornaMetricasTransacoesPort.retornarMetricas();
    }
}

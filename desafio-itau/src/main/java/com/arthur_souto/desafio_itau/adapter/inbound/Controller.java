package com.arthur_souto.desafio_itau.adapter.inbound;

import com.arthur_souto.desafio_itau.adapter.inbound.mapper.DomainToResponseMapper;
import com.arthur_souto.desafio_itau.adapter.inbound.request.TransacaoRequest;
import com.arthur_souto.desafio_itau.adapter.outbound.response.MetricasTransacaoResponse;
import com.arthur_souto.desafio_itau.adapter.outbound.response.TransacaoResponse;
import com.arthur_souto.desafio_itau.application.mapper.RequestToDomainMapper;
import com.arthur_souto.desafio_itau.application.response.TransacaoResponseDomain;
import com.arthur_souto.desafio_itau.application.usecase.ApagarTransacoesNaMemoriaUseCase;
import com.arthur_souto.desafio_itau.application.usecase.RetornaMetricasTransacoesUseCase;
import com.arthur_souto.desafio_itau.application.usecase.SalvarTransacaoNaMemoriaUseCase;
import com.arthur_souto.desafio_itau.domain.MetricasTransacoesResponseDomain;
import com.arthur_souto.desafio_itau.domain.TransacaoDomain;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.OffsetDateTime;

@RestController
public class Controller {

    private final SalvarTransacaoNaMemoriaUseCase salvarTransacaoNaMemoriaUseCase;
    private final ApagarTransacoesNaMemoriaUseCase apagarTransacoesNaMemoriaUseCase;
    private final RetornaMetricasTransacoesUseCase retornaMetricasTransacoesUseCase;

    private static final Logger log = LoggerFactory.getLogger(Controller.class);

    public Controller(SalvarTransacaoNaMemoriaUseCase salvarTransacaoNaMemoriaUseCase,
                      ApagarTransacoesNaMemoriaUseCase apagarTransacoesNaMemoriaUseCase,
                      RetornaMetricasTransacoesUseCase retornaMetricasTransacoesUseCase

    ) {
        this.salvarTransacaoNaMemoriaUseCase = salvarTransacaoNaMemoriaUseCase;
        this.apagarTransacoesNaMemoriaUseCase = apagarTransacoesNaMemoriaUseCase;
        this.retornaMetricasTransacoesUseCase = retornaMetricasTransacoesUseCase;
    }

    @PostMapping("/transacao")
    public ResponseEntity<TransacaoResponse> save(@RequestBody @Valid TransacaoRequest req) {

        log.info("req: {}", req);

        TransacaoDomain domain = RequestToDomainMapper.requestToDomain(req);
        TransacaoResponseDomain responseDomain = this.salvarTransacaoNaMemoriaUseCase.salvar(domain);
        TransacaoResponse response = DomainToResponseMapper.domainToResponse(responseDomain);

        return ResponseEntity.status(response.codigo()).body(response);
    }

    @DeleteMapping("/transacao")
    public ResponseEntity<?> deleteAll() {

        this.apagarTransacoesNaMemoriaUseCase.deletarTransacoes();
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping("/metricas")
    public ResponseEntity<MetricasTransacaoResponse> getMetrics() {

        MetricasTransacoesResponseDomain responseDomain = this.retornaMetricasTransacoesUseCase.retornarMetricas();
        MetricasTransacaoResponse response = DomainToResponseMapper.domainToResponse(responseDomain);

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}

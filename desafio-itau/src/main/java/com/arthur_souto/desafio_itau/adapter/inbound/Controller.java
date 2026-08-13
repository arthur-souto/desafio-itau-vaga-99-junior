package com.arthur_souto.desafio_itau.adapter.inbound;

import com.arthur_souto.desafio_itau.adapter.inbound.mapper.DomainToResponseMapper;
import com.arthur_souto.desafio_itau.adapter.inbound.request.TransacaoRequest;
import com.arthur_souto.desafio_itau.adapter.outbound.response.TransacaoResponse;
import com.arthur_souto.desafio_itau.application.mapper.RequestToDomainMapper;
import com.arthur_souto.desafio_itau.application.response.TransacaoResponseDomain;
import com.arthur_souto.desafio_itau.application.usecase.SalvarTransacaoNaMemoriaUseCase;
import com.arthur_souto.desafio_itau.domain.TransacaoDomain;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    private final SalvarTransacaoNaMemoriaUseCase salvarTransacaoNaMemoriaUseCase;

    private static final Logger log = LoggerFactory.getLogger(Controller.class);

    public Controller(SalvarTransacaoNaMemoriaUseCase salvarTransacaoNaMemoriaUseCase) {
        this.salvarTransacaoNaMemoriaUseCase = salvarTransacaoNaMemoriaUseCase;
    }

    @PostMapping("/transacao")
    public ResponseEntity<TransacaoResponse> save(@RequestBody @Valid TransacaoRequest req) {

        log.info("req: {}", req);

        TransacaoDomain domain = RequestToDomainMapper.requestToDomain(req);
        TransacaoResponseDomain responseDomain = this.salvarTransacaoNaMemoriaUseCase.salvar(domain);
        TransacaoResponse response = DomainToResponseMapper.domainToResponse(responseDomain);

        return ResponseEntity.status(response.codigo()).body(response);
    }
}

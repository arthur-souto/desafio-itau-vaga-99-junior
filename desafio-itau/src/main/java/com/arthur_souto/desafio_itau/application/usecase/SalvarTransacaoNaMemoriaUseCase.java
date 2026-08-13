package com.arthur_souto.desafio_itau.application.usecase;

import com.arthur_souto.desafio_itau.application.port.SalvaTransacaoNaMemoriaPort;
import com.arthur_souto.desafio_itau.application.response.TransacaoResponseDomain;
import com.arthur_souto.desafio_itau.domain.TransacaoDomain;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SalvarTransacaoNaMemoriaUseCase {

    private static final Logger log = LoggerFactory.getLogger(SalvarTransacaoNaMemoriaUseCase.class);
    private final SalvaTransacaoNaMemoriaPort transacaoNaMemoriaPort;

    public SalvarTransacaoNaMemoriaUseCase(SalvaTransacaoNaMemoriaPort transacaoNaMemoriaPort) {
        this.transacaoNaMemoriaPort = transacaoNaMemoriaPort;
    }

    public TransacaoResponseDomain salvar(TransacaoDomain domain) {

       TransacaoResponseDomain result = transacaoNaMemoriaPort.salvarTransacaoNaMemoria(domain);

       log.info("Transacao resgatada do banco: {}", result);

       return result;
    }
}

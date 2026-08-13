package com.arthur_souto.desafio_itau.application.port;

import com.arthur_souto.desafio_itau.application.response.TransacaoResponseDomain;
import com.arthur_souto.desafio_itau.domain.TransacaoDomain;

public interface SalvaTransacaoNaMemoriaPort {
    TransacaoResponseDomain salvarTransacaoNaMemoria(TransacaoDomain domain);
}

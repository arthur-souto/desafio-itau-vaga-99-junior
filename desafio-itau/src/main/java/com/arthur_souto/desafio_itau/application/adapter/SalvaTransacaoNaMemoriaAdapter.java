package com.arthur_souto.desafio_itau.application.adapter;

import com.arthur_souto.desafio_itau.application.port.SalvaTransacaoNaMemoriaPort;
import com.arthur_souto.desafio_itau.application.response.TransacaoResponseDomain;
import com.arthur_souto.desafio_itau.domain.TransacaoDomain;
import com.arthur_souto.desafio_itau.infra.entidade.BancoDeDadosEntidadeResponse;
import com.arthur_souto.desafio_itau.infra.port.BancoDeDadosPort;

public class SalvaTransacaoNaMemoriaAdapter implements SalvaTransacaoNaMemoriaPort {

    private final BancoDeDadosPort bancoDeDadosPort;

    public SalvaTransacaoNaMemoriaAdapter(BancoDeDadosPort bancoDeDadosPort) {
        this.bancoDeDadosPort = bancoDeDadosPort;
    }

    @Override
    public TransacaoResponseDomain salvarTransacaoNaMemoria(TransacaoDomain domain) {
       BancoDeDadosEntidadeResponse<Object> response = bancoDeDadosPort.save(domain);

       final var transacao = (TransacaoDomain) response.getObject();

        return new TransacaoResponseDomain(
                response.getId(),
                transacao.getValor(),
                transacao.getDataHora()
        );

    }
}

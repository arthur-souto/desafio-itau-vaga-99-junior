package com.arthur_souto.desafio_itau.application.adapter;

import com.arthur_souto.desafio_itau.application.port.ApagaTransacoesNaMemoriaPort;
import com.arthur_souto.desafio_itau.infra.port.BancoDeDadosPort;

public class ApagaTransacoesNaMemoriaAdapter implements ApagaTransacoesNaMemoriaPort {

    private final BancoDeDadosPort bancoDeDadosPort;

    public ApagaTransacoesNaMemoriaAdapter(BancoDeDadosPort bancoDeDadosPort) {
        this.bancoDeDadosPort = bancoDeDadosPort;
    }

    @Override
    public void apagarTransacoesNaMemoria() {
        this.bancoDeDadosPort.deleteAll();
    }
}

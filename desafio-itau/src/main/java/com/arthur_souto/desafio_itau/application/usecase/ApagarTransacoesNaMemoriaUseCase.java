package com.arthur_souto.desafio_itau.application.usecase;

import com.arthur_souto.desafio_itau.application.port.ApagaTransacoesNaMemoriaPort;

public class ApagarTransacoesNaMemoriaUseCase {

    private final ApagaTransacoesNaMemoriaPort apagaTransacoesNaMemoriaPort;

    public ApagarTransacoesNaMemoriaUseCase(ApagaTransacoesNaMemoriaPort apagaTransacoesNaMemoriaPort) {
        this.apagaTransacoesNaMemoriaPort = apagaTransacoesNaMemoriaPort;
    }

    public void deletarTransacoes() {
        this.apagaTransacoesNaMemoriaPort.apagarTransacoesNaMemoria();
    }
}

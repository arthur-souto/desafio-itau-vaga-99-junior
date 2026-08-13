package com.arthur_souto.desafio_itau.config;

import com.arthur_souto.desafio_itau.application.adapter.SalvaTransacaoNaMemoriaAdapter;
import com.arthur_souto.desafio_itau.application.port.SalvaTransacaoNaMemoriaPort;
import com.arthur_souto.desafio_itau.application.usecase.SalvarTransacaoNaMemoriaUseCase;
import com.arthur_souto.desafio_itau.infra.adapter.BancoDeDadosEmMemoriaAdapter;
import com.arthur_souto.desafio_itau.infra.port.BancoDeDadosPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GlobalRegisterUseCase {

    @Bean
    public BancoDeDadosPort bancoDeDadosPort() {
        return new BancoDeDadosEmMemoriaAdapter();
    }

    @Bean
    public SalvaTransacaoNaMemoriaPort salvaTransacaoNaMemoriaPort(BancoDeDadosPort bancoDeDadosPort) {
        return new SalvaTransacaoNaMemoriaAdapter(bancoDeDadosPort);
    }

    @Bean
    public SalvarTransacaoNaMemoriaUseCase salvarTransacaoNaMemoriaUseCase(SalvaTransacaoNaMemoriaPort port) {
        return new SalvarTransacaoNaMemoriaUseCase(port);
    }
}

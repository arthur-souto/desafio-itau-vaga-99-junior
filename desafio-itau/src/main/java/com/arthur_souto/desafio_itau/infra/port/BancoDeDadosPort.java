package com.arthur_souto.desafio_itau.infra.port;

import com.arthur_souto.desafio_itau.infra.entidade.BancoDeDadosEntidadeResponse;

public interface BancoDeDadosPort {
    BancoDeDadosEntidadeResponse<Object> save(Object obj);
    void deleteAll();
}

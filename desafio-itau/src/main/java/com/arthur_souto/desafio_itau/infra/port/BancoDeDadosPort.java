package com.arthur_souto.desafio_itau.infra.port;

import com.arthur_souto.desafio_itau.infra.entidade.BancoDeDadosEntidadeResponse;

import java.util.List;

public interface BancoDeDadosPort {
    BancoDeDadosEntidadeResponse<Object> save(Object obj);
    void deleteAll();
    List<BancoDeDadosEntidadeResponse<Object>> findAll();
}

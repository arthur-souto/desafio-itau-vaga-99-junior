package com.arthur_souto.desafio_itau.infra.port;

import com.arthur_souto.desafio_itau.infra.entidade.BancoDeDadosEntidade;

import java.util.List;

public interface BancoDeDadosPort {
    BancoDeDadosEntidade<Object> save(Object obj, String table);
    void deleteAll(String table);
    List<BancoDeDadosEntidade<Object>> findAll(String table);
}

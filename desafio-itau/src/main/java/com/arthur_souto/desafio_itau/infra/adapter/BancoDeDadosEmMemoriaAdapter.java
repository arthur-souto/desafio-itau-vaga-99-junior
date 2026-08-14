package com.arthur_souto.desafio_itau.infra.adapter;

import com.arthur_souto.desafio_itau.infra.entidade.BancoDeDadosEntidadeResponse;
import com.arthur_souto.desafio_itau.infra.port.BancoDeDadosPort;
import com.arthur_souto.desafio_itau.utils.LoggerUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

public class BancoDeDadosEmMemoriaAdapter implements BancoDeDadosPort {

    private static final Logger log = LoggerFactory.getLogger(BancoDeDadosEmMemoriaAdapter.class);

    private final HashMap<UUID, BancoDeDadosEntidadeResponse<Object>> db = new HashMap<>();

    @Override
    public BancoDeDadosEntidadeResponse<Object> save(Object obj) {

        final var uuidBancoDeDados = UUID.randomUUID();

        BancoDeDadosEntidadeResponse<Object> response = new BancoDeDadosEntidadeResponse<>(
                obj,
                uuidBancoDeDados
        );

        LoggerUtils.info(log,"Objeto salvo no banco de dados", "Objeto", response);
        db.put(uuidBancoDeDados, response);

        return response;
    }

    @Override
    public void deleteAll() {

        LoggerUtils.info(log, "Apagando objetos do banco de dados", "Objetos", db);
        db.clear();
    }

    @Override
    public List<BancoDeDadosEntidadeResponse<Object>> findAll() {

        var objetos = db.values().stream().toList();
        LoggerUtils.info(log, "Objetos salvos no banco de dados", "Objetos", objetos);

        return objetos;

    }
}

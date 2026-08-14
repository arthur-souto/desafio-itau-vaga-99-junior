package com.arthur_souto.desafio_itau.infra.adapter;

import com.arthur_souto.desafio_itau.infra.entidade.BancoDeDadosEntidade;
import com.arthur_souto.desafio_itau.infra.port.BancoDeDadosPort;
import com.arthur_souto.desafio_itau.utils.LoggerUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

public class BancoDeDadosEmMemoriaAdapter implements BancoDeDadosPort {

    private static final Logger log = LoggerFactory.getLogger(BancoDeDadosEmMemoriaAdapter.class);

    private final HashMap<UUID, BancoDeDadosEntidade<Object>> db = new HashMap<>();

    @Override
    public BancoDeDadosEntidade<Object> save(Object obj, String table) {

        final var uuidBancoDeDados = UUID.randomUUID();

        BancoDeDadosEntidade<Object> response = new BancoDeDadosEntidade<>(
                uuidBancoDeDados,
                obj,
                table
        );

        LoggerUtils.info(log,"Objeto salvo no banco de dados", "Objeto", response);
        db.put(uuidBancoDeDados, response);

        return response;
    }

    @Override
    public void deleteAll(String table) {

        LoggerUtils.info(log, "Apagando objetos do banco de dados", "Objetos", db);

        db.entrySet().removeIf(
                entry -> entry.getValue().getTableName().equalsIgnoreCase(table));
    }

    @Override
    public List<BancoDeDadosEntidade<Object>> findAll(String table) {

        var objetos = db.values().stream().filter(value -> value.getTableName().equalsIgnoreCase(table)).toList();
        LoggerUtils.info(log, "Objetos no banco de dados", "Objetos", objetos);

        return objetos;

    }
}

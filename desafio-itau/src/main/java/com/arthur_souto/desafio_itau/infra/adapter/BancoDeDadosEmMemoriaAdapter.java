package com.arthur_souto.desafio_itau.infra.adapter;

import com.arthur_souto.desafio_itau.infra.entidade.BancoDeDadosEntidadeResponse;
import com.arthur_souto.desafio_itau.infra.port.BancoDeDadosPort;
import com.arthur_souto.desafio_itau.utils.LoggerUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.HashMap;
import java.util.UUID;

public class BancoDeDadosEmMemoriaAdapter implements BancoDeDadosPort {

    private static final Logger log = LoggerFactory.getLogger(BancoDeDadosEmMemoriaAdapter.class);

    private final HashMap<UUID, Object> db = new HashMap<>();

    @Override
    public BancoDeDadosEntidadeResponse<Object> save(Object obj) {

        final var uuidGerado = UUID.randomUUID();

        BancoDeDadosEntidadeResponse<Object> response = new BancoDeDadosEntidadeResponse<>(
                obj,
                uuidGerado
        );

        LoggerUtils.info(log,"Objeto salvo no banco de dados", "entidade", response);

        db.put(uuidGerado, response);
        return response;
    }
}

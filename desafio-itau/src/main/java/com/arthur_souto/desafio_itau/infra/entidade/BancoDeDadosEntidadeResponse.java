package com.arthur_souto.desafio_itau.infra.entidade;

import java.util.UUID;

public class BancoDeDadosEntidadeResponse<T> {

    UUID id;
    T object;

    public BancoDeDadosEntidadeResponse(T object, UUID id) {
        this.object = object;
        this.id = id;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public T getObject() {
        return object;
    }

    public void setObject(T object) {
        this.object = object;
    }

}

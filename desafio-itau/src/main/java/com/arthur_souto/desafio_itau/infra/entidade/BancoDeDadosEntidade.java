package com.arthur_souto.desafio_itau.infra.entidade;

import java.util.UUID;

public class BancoDeDadosEntidade<T> {

    UUID id;
    String tableName;
    T object;

    public BancoDeDadosEntidade(UUID id, T object, String tableName) {
        this.id = id;
        this.object = object;
        this.tableName = tableName;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
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

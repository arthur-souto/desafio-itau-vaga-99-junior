package com.arthur_souto.desafio_itau.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import net.logstash.logback.argument.StructuredArguments;
import org.slf4j.Logger;

public final class LoggerUtils {

    private static final ObjectMapper mapper = new ObjectMapper()
            .registerModule(new JavaTimeModule());

    private LoggerUtils() {
        // classe utilitária, não instanciável
    }

    /**
     * Loga uma mensagem com um objeto anexado como campo JSON estruturado
     * (aparece separado no log, navegável, não como string dentro de "message").
     */
    public static void info(Logger logger, String message, String fieldName, Object obj) {
        logger.info(message, StructuredArguments.value(fieldName, obj));
    }

    public static void error(Logger logger, String message, String fieldName, Object obj) {
        logger.error(message, StructuredArguments.value(fieldName, obj));
    }

    public static void warn(Logger logger, String message, String fieldName, Object obj) {
        logger.warn(message, StructuredArguments.value(fieldName, obj));
    }

    /**
     * Loga um objeto formatado (pretty-printed) dentro da própria mensagem de texto.
     * Útil pra debug local onde você quer ver o JSON legível no console.
     */
    public static void infoPretty(Logger logger, String message, Object obj) {
        logger.info("{}\n{}", message, toPrettyJson(obj));
    }

    /**
     * Converte qualquer objeto em JSON formatado (indentado). Se falhar
     * a serialização, cai no toString() padrão pra não quebrar o log.
     */
    public static String toPrettyJson(Object obj) {
        try {
            return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(obj);
        } catch (Exception e) {
            return String.valueOf(obj);
        }
    }

    /**
     * Converte qualquer objeto em JSON compacto (uma linha).
     */
    public static String toJson(Object obj) {
        try {
            return mapper.writeValueAsString(obj);
        } catch (Exception e) {
            return String.valueOf(obj);
        }
    }
}
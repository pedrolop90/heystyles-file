package com.heystyles.common.exception;

public class APIExceptions extends RuntimeException {
    public APIExceptions(String message) {
        super(message);
    }

    public static APIExceptions objetoNoEncontrado(String message) {
        return new APIExceptions(message);
    }
}

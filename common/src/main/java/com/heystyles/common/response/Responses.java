package com.heystyles.common.response;

import org.springframework.http.ResponseEntity;

public final class Responses {

    private Responses() {
    }

    public static <T> ResponseEntity<T> responseEntity(T body) {
        return ResponseEntity.ok(body);
    }
}

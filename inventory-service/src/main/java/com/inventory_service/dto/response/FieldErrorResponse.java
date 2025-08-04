package com.inventory_service.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.Map;

@Getter
@Setter
public class FieldErrorResponse {

    private Map<String, String> message;
    private Instant time;

    public FieldErrorResponse(Map<String, String> message) {
        this.message = message;
        this.time = Instant.now();
    }
}

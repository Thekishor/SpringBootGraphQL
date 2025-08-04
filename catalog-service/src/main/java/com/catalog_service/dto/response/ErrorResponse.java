package com.catalog_service.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
public class ErrorResponse {

    private String message;
    private Instant time;

    public ErrorResponse(String message){
        this.message = message;
        this.time = Instant.now();
    }
}


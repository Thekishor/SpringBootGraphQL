package com.inventory_service.exception;

import com.inventory_service.dto.response.ErrorResponse;
import com.inventory_service.dto.response.FieldErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ErrorResponse> runtimeException(RuntimeException exception) {
        String message = exception.getMessage();
        return new ResponseEntity<>(new ErrorResponse(message), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ResourceAlreadyExistsException.class)
    public ResponseEntity<ErrorResponse> resourceAlreadyExistsException(ResourceAlreadyExistsException exception) {
        String message = exception.getMessage();
        return new ResponseEntity<>(new ErrorResponse(message), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<FieldErrorResponse> handleFieldValidation(MethodArgumentNotValidException exception) {
        Map<String, String> errors = new HashMap<>();
        exception.getBindingResult().getFieldErrors().forEach(error -> {
                    String fieldName = error.getField();
                    String message = error.getDefaultMessage();
                    errors.put(fieldName, message);
                }
        );
        return new ResponseEntity<>(new FieldErrorResponse(errors), HttpStatus.BAD_REQUEST);
    }
}

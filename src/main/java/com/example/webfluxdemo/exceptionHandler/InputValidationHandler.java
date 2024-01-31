package com.example.webfluxdemo.exceptionHandler;

import com.example.webfluxdemo.dto.InputFailedValidationError;
import com.example.webfluxdemo.dto.InputFailedValidationResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class InputValidationHandler {
    @ExceptionHandler(InputFailedValidationError.class)
    public ResponseEntity<InputFailedValidationResponse>
    handleException(InputFailedValidationError ex){
        InputFailedValidationResponse response =
                new InputFailedValidationResponse();
        response.setInput(ex.getInput());
        response.setMessage(ex.getMessage());
        response.setErrorCode(ex.getErrorCode());
        return  ResponseEntity.badRequest().body(response);
    }
}

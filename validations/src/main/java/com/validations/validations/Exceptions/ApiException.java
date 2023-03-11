package com.validations.validations.Exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class ApiException extends RuntimeException {
    private String message;
    private Boolean isDone;

    private HttpStatus status;

    public ApiException(String message, Boolean isDone, HttpStatus httpStatus){
        this.message = message;
        this.isDone = isDone;
        this.status = httpStatus;
    }
}

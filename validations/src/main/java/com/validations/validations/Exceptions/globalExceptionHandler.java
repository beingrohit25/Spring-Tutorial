package com.validations.validations.Exceptions;

import com.validations.validations.Payload.ApiResponse;
import org.hibernate.hql.internal.ast.DetailedSemanticException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.lang.reflect.MalformedParametersException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestControllerAdvice
public class globalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> methodArgumentNotValidHandler(MethodArgumentNotValidException exception){
        Map<String, String> data = new HashMap<>();
        exception.getBindingResult().getFieldErrors().forEach(e-> {
            String field = e.getField();
            //String field = ((FieldError)e).getField();
            String defaultMessage = e.getDefaultMessage();
            data.put(field, defaultMessage);
        });
        return new ResponseEntity<>(data, HttpStatus.BAD_REQUEST);
    }

//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public ResponseEntity<?> methodArgumentNotValidHandler1(MethodArgumentNotValidException exception){
//        return new ResponseEntity<>("Enter correct data", HttpStatus.BAD_REQUEST);
//    }

//    @ExceptionHandler(ApiException.class)
//    public ResponseEntity<?> apiExceptionHandler(ApiException exception){
//        return new ResponseEntity<>(new ApiResponse(exception.getMessage(), exception.getIsDone()), HttpStatus.BAD_REQUEST);
//    }

    @ExceptionHandler(ApiException.class)
    public ResponseEntity<?> apiExceptionHandler(ApiException exception){
        return new ResponseEntity<>(new ApiResponse(exception.getMessage(), exception.getIsDone()), exception.getStatus());
    }
    @ExceptionHandler(detailsNotFoundException.class)
    public ResponseEntity<?> detailsHandler(detailsNotFoundException exception){
        String message = exception.getMessage();
        return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
    }

}

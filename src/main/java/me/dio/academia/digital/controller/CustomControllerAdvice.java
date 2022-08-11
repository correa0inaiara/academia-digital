package me.dio.academia.digital.controller;

import me.dio.academia.digital.exception.CaptureErrorsException;
import me.dio.academia.digital.exception.DuplicateValueException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class CustomControllerAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler(CaptureErrorsException.class)
    public ResponseEntity<Object> validationErrorHandler(CaptureErrorsException captureErrorsException) {
        Errors errors = captureErrorsException.getErrors();
        List<FieldError> fieldErrors = errors.getFieldErrors();

        List<Map<String, String>> errorsList = new ArrayList<>();
        fieldErrors.stream().forEach(e -> {
            Map<String, String> errorObj = new HashMap<>();
            errorObj.put("field", e.getField());
            errorObj.put("message", e.getDefaultMessage());
            errorsList.add(errorObj);
        });

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorsList);
    }

//    @ExceptionHandler(DuplicateValueException.class)
//    public ResponseEntity<Object> duplicateErrorHandler(DuplicateValueException duplicateValueException) {
//
//        Map<String, String> errorObj = new HashMap<>();
//        errorObj.put("message", "")
//    }

}

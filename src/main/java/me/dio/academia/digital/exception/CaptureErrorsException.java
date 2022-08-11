package me.dio.academia.digital.exception;

import org.springframework.validation.Errors;

public class CaptureErrorsException extends Exception {

    Errors errors;

    public CaptureErrorsException(Errors errors) {
        this.errors = errors;
    }

    public Errors getErrors() {
        return errors;
    }
}

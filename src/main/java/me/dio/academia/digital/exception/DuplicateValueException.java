package me.dio.academia.digital.exception;

public class DuplicateValueException extends Exception {

    private String field;
    private String message;

    public DuplicateValueException(String field, String message) {
        this.field = field;
        this.message = message;
    }

    public String getField() {
        return field;
    }

    @Override
    public String getMessage() {
        return message;
    }
}

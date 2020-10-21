package ru.isaev.devicesdemo.rest.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomGlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ThereIsNotFoundProjectException.class)
    protected ResponseEntity<CustomGlobalExceptionHandler.AwesomeException> handleThereIsNotFoundBookException() {
        return new ResponseEntity<>(new CustomGlobalExceptionHandler.AwesomeException("Нет проекта с таким Id"), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ThereIsUnacceptableValueException.class)
    protected ResponseEntity<CustomGlobalExceptionHandler.AwesomeException> handleThereIsUnacceptableValueException() {
        return new ResponseEntity<>(new CustomGlobalExceptionHandler.AwesomeException("Id должен быть больше 1"), HttpStatus.NOT_FOUND);
    }

    @Data
    @AllArgsConstructor
    static class AwesomeException {
        private String message;
    }
}

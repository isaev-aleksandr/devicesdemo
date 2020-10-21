package ru.isaev.devicesdemo.rest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Id должен быть больше 1")
public class ThereIsUnacceptableValueException extends RuntimeException{ }

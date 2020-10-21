package ru.isaev.devicesdemo.rest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Нет проекта с таким Id")
public class ThereIsNotFoundProjectException extends RuntimeException{

}

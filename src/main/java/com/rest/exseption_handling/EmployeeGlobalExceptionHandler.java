package com.rest.exseption_handling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class EmployeeGlobalExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<EmployeeIncorrectData> handlerException(NoSuchEmployeeException exception) {
        EmployeeIncorrectData incorrectData = new EmployeeIncorrectData();
        incorrectData.setInfo(exception.getMessage());
        return new ResponseEntity<>(incorrectData, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler
    public ResponseEntity<EmployeeIncorrectData> handlerException(Exception exception) {
        EmployeeIncorrectData incorrectData = new EmployeeIncorrectData();
        incorrectData.setInfo(exception.getMessage());
        return new ResponseEntity<>(incorrectData, HttpStatus.BAD_REQUEST);
    }
}

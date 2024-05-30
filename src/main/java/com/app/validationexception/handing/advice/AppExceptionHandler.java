package com.app.validationexception.handing.advice;

import com.app.validationexception.handing.exception.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;
@RestControllerAdvice
public class AppExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String,String>> handleInvalidArguments(MethodArgumentNotValidException ex){
        Map<String,String> errMsg=new HashMap<>();
        ex.getBindingResult().getFieldErrors()
                .forEach(err->errMsg.put(err.getField(),err.getDefaultMessage()));
        return new ResponseEntity<>(errMsg, HttpStatus.BAD_GATEWAY);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<Map<String,String>> handleBusinessException(UserNotFoundException ex){

        Map<String,String> errMsg=new HashMap<>();
        errMsg.put("error msg",ex.getMessage());
        return new ResponseEntity<>(errMsg,HttpStatus.INTERNAL_SERVER_ERROR);
    }

}

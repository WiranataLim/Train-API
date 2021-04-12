/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proifh.trainmanager.controller;
import java.util.HashMap;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.NoHandlerFoundException;
/**
 *
 * @author VRABS
 */
@RestControllerAdvice
public class ExceptionResolver {
    @ExceptionHandler({NoHandlerFoundException.class, MethodArgumentTypeMismatchException.class, MissingServletRequestParameterException.class})
    @ResponseStatus(value= HttpStatus.METHOD_NOT_ALLOWED)
    public HashMap<String, String> handleNoHandlerFound(Exception e, WebRequest request) {
        HashMap<String, String> response = new HashMap<>();
        response.put("message", "invalid endpoint");
        return response;
    }
    
    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseStatus(value= HttpStatus.BAD_REQUEST)
    public HashMap<String, String> BadPostRequest(Exception e, WebRequest request) {
        HashMap<String, String> response = new HashMap<>();
        response.put("message", "failed validation");
        return response;
    }
}

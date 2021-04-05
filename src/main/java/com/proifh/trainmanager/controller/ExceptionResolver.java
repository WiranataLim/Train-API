/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proifh.trainmanager.controller;
import java.util.HashMap;
import org.springframework.http.HttpStatus;
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
    @ExceptionHandler({NoHandlerFoundException.class, MethodArgumentTypeMismatchException.class})
    @ResponseStatus(value= HttpStatus.METHOD_NOT_ALLOWED)
    public HashMap<String, String> handleNoHandlerFound(Exception e, WebRequest request) {
        System.out.println("Resolving...");
        HashMap<String, String> response = new HashMap<>();
        response.put("message", "invalid endpoint");
        return response;
    }
}
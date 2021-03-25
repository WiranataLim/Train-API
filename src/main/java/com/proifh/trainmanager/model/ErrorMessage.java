/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proifh.trainmanager.model;

import java.util.Date;

/**
 *
 * @author VRABS
 */
public class ErrorMessage {
    private Date timestamp;
    private String message;
    private int code;

    public ErrorMessage() {
    }

    public ErrorMessage(Date timestamp, String message, int code) {
        this.timestamp = timestamp;
        this.message = message;
        this.code = code;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
    
    
}

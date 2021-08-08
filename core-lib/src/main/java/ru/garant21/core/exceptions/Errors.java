package ru.garant21.core.exceptions;

import lombok.Data;

import java.util.Date;

@Data
public class Errors {
    private int status;
    private String message;
    private Date timeStamp;

    public Errors(int status, String message) {
        this.status = status;
        this.message = message;
        this.timeStamp = new Date();
    }
}

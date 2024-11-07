package com.workintech.s19d1.exceptions;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class ExceptionResponse {
    private String message;
    private int status;
    private LocalDateTime dateTime;



    public ExceptionResponse(LocalDateTime dateTime, String message, int status) {
        this.dateTime = dateTime;
        this.message = message;
        this.status = status;
    }


}

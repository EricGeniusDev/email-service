package com.example.emailservice.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

public class EmailDTO implements Serializable {
    public String from;
    public String to;
    private LocalDateTime includeDate = LocalDateTime.now();
    public String message;


    public LocalDateTime getIncludeDate() {
        return includeDate;
    }
}

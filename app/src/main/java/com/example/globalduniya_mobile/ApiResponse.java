package com.example.globalduniya_mobile;

import java.util.List;

public class ApiResponse {
    private boolean status;
    private List<Tour> data;
    private String message;

    // Getters
    public boolean isStatus() {
        return status;
    }

    public List<Tour> getData() {
        return data;
    }

    public String getMessage() {
        return message;
    }
}
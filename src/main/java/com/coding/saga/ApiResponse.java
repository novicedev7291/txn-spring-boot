package com.coding.saga;

public class ApiResponse {
    private final String message;
    private final Integer code;

    public ApiResponse(String message, Integer code) {
        this.message = message;
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public Integer getCode() {
        return code;
    }
}

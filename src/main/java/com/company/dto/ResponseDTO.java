package com.company.dto;

public class ResponseDTO {
    private Object object;
    private String message;

    public ResponseDTO(Object object, String message) {
        this.object = object;
        this.message = message;
    }

    public ResponseDTO(String message) {
        this.message = message;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

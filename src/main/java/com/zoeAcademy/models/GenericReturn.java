package com.zoeAcademy.models;

import lombok.Data;

@Data
public class GenericReturn<T> {

    private boolean success;
    private String message;
    private T result;

    public GenericReturn() {

    }

    public GenericReturn(boolean success, String message, T result) {
        this.success = success;
        this.message = message;
        this.result = result;
    }
}

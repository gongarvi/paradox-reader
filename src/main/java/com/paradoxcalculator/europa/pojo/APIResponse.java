package com.paradoxcalculator.europa.pojo;

public class APIResponse<T>{
    private T body;
    private String message;
    private int code;

    public APIResponse(String message){
        this.code = 0;
        this.message = message;
        this.body = null;
    }

    public APIResponse(T body, String message){
        this.code = 0;
        this.message = message;
        this.body = body;
    }

    public APIResponse(T body, String message, int code){
        this.code = 0;
        this.message = message;
        this.body = body;
    }
}

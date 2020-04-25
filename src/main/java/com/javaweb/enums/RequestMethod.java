package com.javaweb.enums;

public enum RequestMethod {
    GET("GET"),POST("POST"),PUT("PUT"),DELETE("DELETE"),PATCH("PATCH"),OPTIONS("OPTIONS"),HEAD("HEAD"),TRACE("TRACE");

    private String method;
    public String getMethod(){
        return method;
    }
    RequestMethod(String method) {
        this.method = method;
    }
}

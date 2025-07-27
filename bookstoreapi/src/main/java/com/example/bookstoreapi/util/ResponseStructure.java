package com.example.bookstoreapi.util;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Standard response structure")
public class ResponseStructure<T> {
    private int statusCode;
    private String messsage;
    private T data;

    
    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getMesssage() {
        return messsage;
    }

    public void setMesssage(String messsage) {
        this.messsage = messsage;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}

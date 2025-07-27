package com.example.bookstoreapi.util;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;

@Schema(description = "Standard list response structure")
public class ResponseStructureList<T> {
    private int statusCode;
    private String messsage;
    private List<T> data;

    
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

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}

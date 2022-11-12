package com.akamarket.akamarket.helper;

public class Alert {
    private String message;
    private String type;

    public Alert(String message,String type){
        this.type = type;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}

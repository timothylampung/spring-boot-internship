package com.timothy.internship.M_core;

public class EmgResponseStatus {


    private String message;
    private boolean success;


    public EmgResponseStatus() {
    }

    public EmgResponseStatus(String message, boolean success) {
        this.message = message;
        this.success = success;
    }


    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public boolean getSuccess() {
        return this.success;
    }

}

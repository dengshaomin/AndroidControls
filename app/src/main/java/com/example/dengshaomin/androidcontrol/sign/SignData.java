package com.example.dengshaomin.androidcontrol.sign;

/**
 * Created by dengshaomin on 2017/2/22.
 */
public class SignData {
    private int code;
    private String message;
    private SignDataData data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public SignDataData getData() {
        return data;
    }

    public void setData(SignDataData data) {
        this.data = data;
    }
}

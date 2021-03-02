package com.tencent.tav.player;

public class ErrorMsg {
    private int errorCode;
    private String errorMsg;

    public ErrorMsg(int i2, String str) {
        this.errorCode = i2;
        this.errorMsg = str;
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public String getErrorMsg() {
        return this.errorMsg;
    }
}

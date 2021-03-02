package com.tencent.tav.coremedia;

public class ErrorMsg {
    int errorCode;
    String errorMsg;

    public ErrorMsg() {
    }

    public ErrorMsg(int i2, String str) {
        this.errorCode = i2;
        this.errorMsg = str;
    }
}

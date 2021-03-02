package com.tencent.map.tools.net.exception;

public class NetCustomException extends Exception {
    private static final long serialVersionUID = -5614711401833110994L;
    private Exception exception;
    private int netCode;

    public NetCustomException() {
    }

    public NetCustomException(String str, Exception exc, int i2) {
        super(str);
        this.exception = exc;
        this.netCode = i2;
    }

    public Exception getException() {
        return this.exception;
    }

    public int getNetCode() {
        return this.netCode;
    }
}

package com.tencent.map.tools.net.exception;

public class NetJceDataException extends Exception {
    private static final long serialVersionUID = 1;

    public NetJceDataException() {
    }

    public NetJceDataException(String str, Throwable th) {
        super(str, th);
    }

    public NetJceDataException(String str) {
        super(str);
    }

    public NetJceDataException(Throwable th) {
        super(th);
    }
}

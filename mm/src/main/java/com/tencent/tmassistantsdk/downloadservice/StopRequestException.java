package com.tencent.tmassistantsdk.downloadservice;

public class StopRequestException extends Exception {
    protected static final long serialVersionUID = 1;
    public final int mFinalErrCode;

    public StopRequestException(int i2, String str) {
        super(str);
        this.mFinalErrCode = i2;
    }

    public StopRequestException(int i2, Throwable th) {
        super(th);
        this.mFinalErrCode = i2;
    }
}

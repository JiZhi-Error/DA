package com.tencent.tbs.one;

public class TBSOneException extends Exception {

    /* renamed from: a  reason: collision with root package name */
    private int f2317a = -1;

    public TBSOneException(int i2, String str) {
        super(str);
        this.f2317a = i2;
    }

    public TBSOneException(int i2, String str, Throwable th) {
        super(str, th);
        this.f2317a = i2;
    }

    public int getErrorCode() {
        return this.f2317a;
    }
}

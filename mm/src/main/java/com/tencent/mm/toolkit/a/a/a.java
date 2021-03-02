package com.tencent.mm.toolkit.a.a;

public final class a extends Exception {
    public int mErrorCode;

    public a(int i2, String str) {
        super(str);
        this.mErrorCode = i2;
    }
}

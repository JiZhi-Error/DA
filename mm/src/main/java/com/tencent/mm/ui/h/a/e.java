package com.tencent.mm.ui.h.a;

public final class e extends Throwable {
    public String QjS;
    public int mErrorCode = 0;

    public e(String str) {
        super(str);
    }

    public e(String str, String str2, int i2) {
        super(str);
        this.QjS = str2;
        this.mErrorCode = i2;
    }
}

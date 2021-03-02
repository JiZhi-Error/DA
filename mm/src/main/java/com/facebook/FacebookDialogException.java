package com.facebook;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class FacebookDialogException extends FacebookException {
    static final long serialVersionUID = 1;
    private int errorCode;
    private String failingUrl;

    public FacebookDialogException(String str, int i2, String str2) {
        super(str);
        this.errorCode = i2;
        this.failingUrl = str2;
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public String getFailingUrl() {
        return this.failingUrl;
    }

    @Override // com.facebook.FacebookException
    public final String toString() {
        AppMethodBeat.i(7618);
        String str = "{FacebookDialogException: errorCode: " + getErrorCode() + ", message: " + getMessage() + ", url: " + getFailingUrl() + "}";
        AppMethodBeat.o(7618);
        return str;
    }
}

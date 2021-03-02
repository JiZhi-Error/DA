package com.tencent.qqpinyin.voicerecoapi;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b extends Exception {
    private String jFn = "";
    private int mErrorCode;

    public b(int i2) {
        String str;
        AppMethodBeat.i(87698);
        this.mErrorCode = i2;
        switch (i2) {
            case -104:
                str = "null param or 0 length";
                break;
            case -103:
                str = "already init";
                break;
            case -102:
                str = "should init at first";
                break;
            case -101:
                str = "speex engine error";
                break;
            case -100:
                str = "out of memory";
                break;
            default:
                str = "unknown error";
                break;
        }
        this.jFn = str;
        new StringBuilder("errorCode: ").append(this.mErrorCode).append("\t msg: ").append(this.jFn);
        AppMethodBeat.o(87698);
    }
}

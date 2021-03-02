package com.davemorrissey.labs.subscaleview.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c {
    public int errCode;
    public String errMsg;

    public c(int i2, String str) {
        this.errCode = i2;
        this.errMsg = str;
    }

    public final String toString() {
        AppMethodBeat.i(157342);
        String format = String.format("ImageDecodeResult{errCode: %d, errMsg: %s}", Integer.valueOf(this.errCode), this.errMsg);
        AppMethodBeat.o(157342);
        return format;
    }
}

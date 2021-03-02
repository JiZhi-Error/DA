package com.tencent.mm.plugin.appbrand.jsapi.fakenative;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum f {
    OK(0, "ok"),
    SYSTEM_ERROR(-1, "fail system error"),
    CGI_ERROR(-2, "fail CGI error"),
    CANCEL(-3, "fail cancel"),
    INVALID_BUSINESS_TYPE(-4, "fail invalid businessType");
    
    int errCode;
    String errMsg;

    public static f valueOf(String str) {
        AppMethodBeat.i(46296);
        f fVar = (f) Enum.valueOf(f.class, str);
        AppMethodBeat.o(46296);
        return fVar;
    }

    static {
        AppMethodBeat.i(46297);
        AppMethodBeat.o(46297);
    }

    private f(int i2, String str) {
        this.errCode = i2;
        this.errMsg = str;
    }
}

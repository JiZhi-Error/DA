package com.tencent.mm.opensdk.diffdev;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum OAuthErrCode {
    WechatAuth_Err_OK(0),
    WechatAuth_Err_NormalErr(-1),
    WechatAuth_Err_NetworkErr(-2),
    WechatAuth_Err_JsonDecodeErr(-3),
    WechatAuth_Err_Cancel(-4),
    WechatAuth_Err_Timeout(-5),
    WechatAuth_Err_Auth_Stopped(-6);
    
    private int code;

    static {
        AppMethodBeat.i(3748);
        AppMethodBeat.o(3748);
    }

    private OAuthErrCode(int i2) {
        AppMethodBeat.i(190398);
        this.code = i2;
        AppMethodBeat.o(190398);
    }

    public static OAuthErrCode valueOf(String str) {
        AppMethodBeat.i(3746);
        OAuthErrCode oAuthErrCode = (OAuthErrCode) Enum.valueOf(OAuthErrCode.class, str);
        AppMethodBeat.o(3746);
        return oAuthErrCode;
    }

    public final int getCode() {
        return this.code;
    }

    public final String toString() {
        AppMethodBeat.i(3747);
        String str = "OAuthErrCode:" + this.code;
        AppMethodBeat.o(3747);
        return str;
    }
}

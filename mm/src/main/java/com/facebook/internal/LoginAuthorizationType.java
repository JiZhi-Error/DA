package com.facebook.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum LoginAuthorizationType {
    READ,
    PUBLISH;

    public static LoginAuthorizationType valueOf(String str) {
        AppMethodBeat.i(7676);
        LoginAuthorizationType loginAuthorizationType = (LoginAuthorizationType) Enum.valueOf(LoginAuthorizationType.class, str);
        AppMethodBeat.o(7676);
        return loginAuthorizationType;
    }

    static {
        AppMethodBeat.i(7677);
        AppMethodBeat.o(7677);
    }
}

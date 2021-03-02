package com.jg;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum EType {
    ALL,
    ACTIVITYCHECK,
    PROVIDERCHECK,
    RECEIVERCHECK,
    SERVICESCHECK,
    PERMISSIONCHECK,
    INTENTCHECK,
    SECURERANDOMCHECK,
    JSEXECUTECHECK,
    HTTPSCHECK;

    public static EType valueOf(String str) {
        AppMethodBeat.i(61444);
        EType eType = (EType) Enum.valueOf(EType.class, str);
        AppMethodBeat.o(61444);
        return eType;
    }

    static {
        AppMethodBeat.i(61442);
        AppMethodBeat.o(61442);
    }
}

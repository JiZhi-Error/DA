package org.b.d;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum j {
    GET,
    POST,
    PUT,
    DELETE,
    HEAD,
    OPTIONS,
    TRACE,
    PATCH;

    public static j valueOf(String str) {
        AppMethodBeat.i(40516);
        j jVar = (j) Enum.valueOf(j.class, str);
        AppMethodBeat.o(40516);
        return jVar;
    }

    static {
        AppMethodBeat.i(40514);
        AppMethodBeat.o(40514);
    }
}

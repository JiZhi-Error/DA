package com.facebook;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum HttpMethod {
    GET,
    POST,
    DELETE;

    public static HttpMethod valueOf(String str) {
        AppMethodBeat.i(17208);
        HttpMethod httpMethod = (HttpMethod) Enum.valueOf(HttpMethod.class, str);
        AppMethodBeat.o(17208);
        return httpMethod;
    }

    static {
        AppMethodBeat.i(17209);
        AppMethodBeat.o(17209);
    }
}

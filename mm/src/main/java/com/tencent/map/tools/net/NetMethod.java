package com.tencent.map.tools.net;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum NetMethod {
    POST,
    GET,
    URL;

    public static NetMethod valueOf(String str) {
        AppMethodBeat.i(172926);
        NetMethod netMethod = (NetMethod) Enum.valueOf(NetMethod.class, str);
        AppMethodBeat.o(172926);
        return netMethod;
    }

    static {
        AppMethodBeat.i(172927);
        AppMethodBeat.o(172927);
    }
}

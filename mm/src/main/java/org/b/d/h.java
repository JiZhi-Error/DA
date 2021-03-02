package org.b.d;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum h {
    Header,
    QueryString;

    public static h valueOf(String str) {
        AppMethodBeat.i(40547);
        h hVar = (h) Enum.valueOf(h.class, str);
        AppMethodBeat.o(40547);
        return hVar;
    }

    static {
        AppMethodBeat.i(40545);
        AppMethodBeat.o(40545);
    }
}

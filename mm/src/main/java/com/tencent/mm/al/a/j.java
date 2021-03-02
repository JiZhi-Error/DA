package com.tencent.mm.al.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum j {
    BIZ_CHAT_TYPE_UNKNOWN(-1),
    BIZ_CHAT_TYPE_GROUP(1),
    BIZ_CHAT_TYPE_SINGLE(2),
    BIZ_CHAT_TYPE_APP(3);
    
    public final int iQq;

    public static j valueOf(String str) {
        AppMethodBeat.i(212200);
        j jVar = (j) Enum.valueOf(j.class, str);
        AppMethodBeat.o(212200);
        return jVar;
    }

    static {
        AppMethodBeat.i(212201);
        AppMethodBeat.o(212201);
    }

    private j(int i2) {
        this.iQq = i2;
    }
}

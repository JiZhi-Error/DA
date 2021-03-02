package com.tencent.mm.plugin.expt.hellhound.core.stack;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum a {
    CREATE(0),
    RESUME(1),
    PAUSE(2),
    STOP(3),
    DESTROY(4);
    
    int value;

    public static a valueOf(String str) {
        AppMethodBeat.i(121876);
        a aVar = (a) Enum.valueOf(a.class, str);
        AppMethodBeat.o(121876);
        return aVar;
    }

    static {
        AppMethodBeat.i(121877);
        AppMethodBeat.o(121877);
    }

    private a(int i2) {
        this.value = i2;
    }
}

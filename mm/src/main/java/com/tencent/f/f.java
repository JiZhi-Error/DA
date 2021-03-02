package com.tencent.f;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum f {
    THROW(-3),
    ERROR(-2),
    CANCEL(-1),
    CREATED(0),
    WAITING(1),
    RUNNING(2),
    COMPLETE(3);
    
    public int value;

    public static f valueOf(String str) {
        AppMethodBeat.i(183139);
        f fVar = (f) Enum.valueOf(f.class, str);
        AppMethodBeat.o(183139);
        return fVar;
    }

    static {
        AppMethodBeat.i(183140);
        AppMethodBeat.o(183140);
    }

    private f(int i2) {
        this.value = i2;
    }
}

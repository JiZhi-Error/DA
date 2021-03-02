package com.bumptech.glide;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum f {
    LOW(0.5f),
    NORMAL(1.0f),
    HIGH(1.5f);
    
    private final float aCK;

    public static f valueOf(String str) {
        AppMethodBeat.i(76785);
        f fVar = (f) Enum.valueOf(f.class, str);
        AppMethodBeat.o(76785);
        return fVar;
    }

    static {
        AppMethodBeat.i(76786);
        AppMethodBeat.o(76786);
    }

    private f(float f2) {
        this.aCK = f2;
    }
}

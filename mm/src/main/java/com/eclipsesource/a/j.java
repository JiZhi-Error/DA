package com.eclipsesource.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class j extends RuntimeException {
    private final int column;
    private final int line;
    private final int offset;

    j(String str, int i2, int i3, int i4) {
        super(str + " at " + i3 + ":" + i4);
        AppMethodBeat.i(74783);
        this.offset = i2;
        this.line = i3;
        this.column = i4;
        AppMethodBeat.o(74783);
    }
}

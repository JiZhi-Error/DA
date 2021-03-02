package com.google.b.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum a {
    L(1),
    M(0),
    Q(3),
    H(2);
    
    private static final a[] cfc = {M, L, H, Q};
    public final int cfd;

    public static a valueOf(String str) {
        AppMethodBeat.i(12303);
        a aVar = (a) Enum.valueOf(a.class, str);
        AppMethodBeat.o(12303);
        return aVar;
    }

    static {
        AppMethodBeat.i(12304);
        AppMethodBeat.o(12304);
    }

    private a(int i2) {
        this.cfd = i2;
    }
}

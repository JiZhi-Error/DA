package com.tencent.mm.plugin.appbrand.widget.input.d;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum b {
    DONE(6),
    SEARCH(3),
    NEXT(5),
    GO(2),
    SEND(4),
    RETURN(0);
    
    public final int oxA;

    public static b valueOf(String str) {
        AppMethodBeat.i(131522);
        b bVar = (b) Enum.valueOf(b.class, str);
        AppMethodBeat.o(131522);
        return bVar;
    }

    static {
        AppMethodBeat.i(131524);
        AppMethodBeat.o(131524);
    }

    private b(int i2) {
        this.oxA = i2;
    }

    public static b jk(boolean z) {
        return z ? RETURN : DONE;
    }

    public static b aga(String str) {
        AppMethodBeat.i(131523);
        b bVar = (b) d.h(str, b.class);
        AppMethodBeat.o(131523);
        return bVar;
    }
}

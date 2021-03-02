package com.tencent.mm.vending.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Stack;

/* access modifiers changed from: package-private */
public final class f {
    private static f RaD;
    ThreadLocal<Stack<c>> RaE = new ThreadLocal<>();

    private f() {
        AppMethodBeat.i(177491);
        AppMethodBeat.o(177491);
    }

    static {
        AppMethodBeat.i(177492);
        RaD = null;
        RaD = new f();
        AppMethodBeat.o(177492);
    }

    public static f hdF() {
        return RaD;
    }
}

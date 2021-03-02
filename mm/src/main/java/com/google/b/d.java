package com.google.b;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d extends f {
    private static final d cbZ;

    static {
        AppMethodBeat.i(12283);
        d dVar = new d();
        cbZ = dVar;
        dVar.setStackTrace(ccc);
        AppMethodBeat.o(12283);
    }

    private d() {
    }

    public static d Ih() {
        AppMethodBeat.i(12282);
        if (ccb) {
            d dVar = new d();
            AppMethodBeat.o(12282);
            return dVar;
        }
        d dVar2 = cbZ;
        AppMethodBeat.o(12282);
        return dVar2;
    }
}

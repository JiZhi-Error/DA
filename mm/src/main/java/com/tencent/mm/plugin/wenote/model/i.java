package com.tencent.mm.plugin.wenote.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.f;
import com.tencent.mm.model.bg;
import com.tencent.mm.protocal.b.a.c;

public final class i {
    private static final f<Integer, c> gAU = new com.tencent.mm.memory.a.c(32);

    public static String aTk() {
        AppMethodBeat.i(30340);
        bg.aVF();
        String aTk = com.tencent.mm.model.c.aTk();
        AppMethodBeat.o(30340);
        return aTk;
    }

    static {
        AppMethodBeat.i(30341);
        AppMethodBeat.o(30341);
    }
}

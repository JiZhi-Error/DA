package com.tencent.mm.plugin.abtest;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.c.d;
import com.tencent.mm.model.y;

public final class c extends y {
    private static c jZf;

    private c() {
        super(d.class);
    }

    public static synchronized c bna() {
        c cVar;
        synchronized (c.class) {
            AppMethodBeat.i(153140);
            if (jZf == null) {
                jZf = new c();
            }
            cVar = jZf;
            AppMethodBeat.o(153140);
        }
        return cVar;
    }

    @Override // com.tencent.mm.kernel.api.f, com.tencent.mm.model.y
    public final void FU(String str) {
        AppMethodBeat.i(153141);
        super.FU(str);
        AppMethodBeat.o(153141);
    }
}

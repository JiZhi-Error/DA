package com.tencent.mm.plugin.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.c;

public final class b implements c {
    private static b zoC;

    private b() {
    }

    public static synchronized b eip() {
        b bVar;
        synchronized (b.class) {
            AppMethodBeat.i(151500);
            if (zoC == null) {
                zoC = new b();
            }
            bVar = zoC;
            AppMethodBeat.o(151500);
        }
        return bVar;
    }
}

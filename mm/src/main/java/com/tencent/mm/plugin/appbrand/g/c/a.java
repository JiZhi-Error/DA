package com.tencent.mm.plugin.appbrand.g.c;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class a {
    private static a lks;

    public static a bBu() {
        AppMethodBeat.i(158949);
        if (lks == null) {
            synchronized (a.class) {
                try {
                    if (lks == null) {
                        lks = new a();
                    }
                } catch (Throwable th) {
                    AppMethodBeat.o(158949);
                    throw th;
                }
            }
        }
        a aVar = lks;
        AppMethodBeat.o(158949);
        return aVar;
    }

    private a() {
    }
}

package com.tencent.luggage.game.b;

import com.tencent.luggage.game.c.g;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class c {
    private static volatile c cuD;
    public g cuE = new com.tencent.luggage.game.c.c();

    protected c() {
        AppMethodBeat.i(130470);
        AppMethodBeat.o(130470);
    }

    public static c LV() {
        AppMethodBeat.i(130471);
        if (cuD == null) {
            synchronized (c.class) {
                try {
                    if (cuD == null) {
                        cuD = new c();
                    }
                } catch (Throwable th) {
                    AppMethodBeat.o(130471);
                    throw th;
                }
            }
        }
        c cVar = cuD;
        AppMethodBeat.o(130471);
        return cVar;
    }
}

package com.tencent.xweb.b;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class g {
    static f SCB = null;

    static synchronized f htt() {
        f fVar;
        synchronized (g.class) {
            AppMethodBeat.i(183512);
            if (SCB == null) {
                fVar = new c();
                AppMethodBeat.o(183512);
            } else {
                fVar = SCB;
                AppMethodBeat.o(183512);
            }
        }
        return fVar;
    }
}

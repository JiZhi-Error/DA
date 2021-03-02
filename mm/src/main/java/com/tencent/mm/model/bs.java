package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.network.m;

public final class bs {
    public static a iFc = null;

    public interface a {
        int aVX();

        m aVY();
    }

    public static m a(m mVar) {
        AppMethodBeat.i(132251);
        if (iFc == null) {
            AppMethodBeat.o(132251);
            return mVar;
        }
        m aVY = iFc.aVY();
        AppMethodBeat.o(132251);
        return aVY;
    }

    public static int aVX() {
        AppMethodBeat.i(132252);
        if (iFc != null) {
            int aVX = iFc.aVX();
            AppMethodBeat.o(132252);
            return aVX;
        }
        AppMethodBeat.o(132252);
        return 0;
    }
}

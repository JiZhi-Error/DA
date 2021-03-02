package com.tencent.mm.plugin.appbrand.ac;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import com.tencent.mm.sdk.platformtools.Util;

public final class j {
    public static <T extends a> boolean a(T t, T t2) {
        boolean z = false;
        AppMethodBeat.i(146131);
        if (t == null && t2 == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("both null!!!");
            AppMethodBeat.o(146131);
            throw illegalArgumentException;
        }
        if (t == null) {
            AppMethodBeat.o(146131);
        } else if (t2 == null) {
            AppMethodBeat.o(146131);
        } else {
            try {
                z = Util.isEqual(t.toByteArray(), t2.toByteArray());
                AppMethodBeat.o(146131);
            } catch (Exception e2) {
                AppMethodBeat.o(146131);
            }
        }
        return z;
    }
}

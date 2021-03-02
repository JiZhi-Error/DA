package com.tencent.mm.cq;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;

public final class c {
    public static void aqp(int i2) {
        AppMethodBeat.i(152890);
        Log.i("BigImageReporter", "alvinluo reportMTKPlatform apiLevel: %d", Integer.valueOf(i2));
        if (i2 == 24) {
            h.INSTANCE.n(896, 0, 1);
            AppMethodBeat.o(152890);
            return;
        }
        if (i2 == 25) {
            h.INSTANCE.n(896, 1, 1);
        }
        AppMethodBeat.o(152890);
    }

    public static void aqq(int i2) {
        AppMethodBeat.i(223906);
        Log.i("BigImageReporter", "alvinluo reportLoadError errCode: %d", Integer.valueOf(i2));
        if (i2 == 4) {
            h.INSTANCE.n(896, 2, 1);
            AppMethodBeat.o(223906);
            return;
        }
        if (i2 == 5) {
            h.INSTANCE.n(896, 3, 1);
        }
        AppMethodBeat.o(223906);
    }
}

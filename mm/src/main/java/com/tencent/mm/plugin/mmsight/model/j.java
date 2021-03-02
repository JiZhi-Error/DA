package com.tencent.mm.plugin.mmsight.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMHandler;

public final class j {
    private static MMHandler zuu = new MMHandler("MMSightHandler");

    static {
        AppMethodBeat.i(89420);
        AppMethodBeat.o(89420);
    }

    public static void aj(Runnable runnable) {
        AppMethodBeat.i(89418);
        zuu.postToWorker(runnable);
        AppMethodBeat.o(89418);
    }

    public static void ak(Runnable runnable) {
        AppMethodBeat.i(89419);
        zuu.postDelayed(runnable, 2000);
        AppMethodBeat.o(89419);
    }
}

package com.tencent.mm.ch;

import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;

public final class a {
    public static boolean post(Runnable runnable) {
        AppMethodBeat.i(156366);
        h.RTc.aX(runnable);
        AppMethodBeat.o(156366);
        return true;
    }

    public static boolean x(Runnable runnable) {
        AppMethodBeat.i(156367);
        h.RTc.o(runnable, 1000);
        AppMethodBeat.o(156367);
        return true;
    }

    public static boolean y(Runnable runnable) {
        AppMethodBeat.i(182045);
        MMHandlerThread.postToMainThread(runnable);
        AppMethodBeat.o(182045);
        return true;
    }
}

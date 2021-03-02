package com.tencent.mm.plugin.game.commlib.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.vending.h.g;

public final class a {
    private static final Object ogA = new Object();
    private static volatile MMHandler xvA;

    static {
        AppMethodBeat.i(89962);
        AppMethodBeat.o(89962);
    }

    public static void bZm() {
        AppMethodBeat.i(89960);
        if (xvA == null) {
            AppMethodBeat.o(89960);
            return;
        }
        synchronized (ogA) {
            try {
                if (xvA != null) {
                    g.boG("GameCommLib#WorkThread");
                    xvA.quit();
                    xvA = null;
                }
            } finally {
                AppMethodBeat.o(89960);
            }
        }
    }

    public static MMHandler getWorkerHandler() {
        AppMethodBeat.i(184541);
        if (xvA == null) {
            synchronized (ogA) {
                try {
                    if (xvA == null) {
                        xvA = new MMHandler("GameCommLib#WorkThread");
                        g.a("GameCommLib#WorkThread", new com.tencent.mm.cd.a("GameCommLib#WorkThread"));
                    }
                } catch (Throwable th) {
                    AppMethodBeat.o(184541);
                    throw th;
                }
            }
        }
        MMHandler mMHandler = xvA;
        AppMethodBeat.o(184541);
        return mMHandler;
    }
}

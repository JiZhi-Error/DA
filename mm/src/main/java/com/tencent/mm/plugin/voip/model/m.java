package com.tencent.mm.plugin.voip.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.locks.ReentrantLock;

public final class m {
    private static m GWz = new m();
    private l GWA;
    private ReentrantLock dgE = new ReentrantLock();

    static {
        AppMethodBeat.i(114940);
        AppMethodBeat.o(114940);
    }

    private m() {
        AppMethodBeat.i(114938);
        AppMethodBeat.o(114938);
    }

    public static l fGM() {
        AppMethodBeat.i(114939);
        if (GWz.GWA == null) {
            GWz.dgE.lock();
            try {
                if (GWz.GWA == null) {
                    GWz.GWA = new l();
                }
                GWz.dgE.unlock();
            } catch (Throwable th) {
                GWz.dgE.unlock();
                AppMethodBeat.o(114939);
                throw th;
            }
        }
        l lVar = GWz.GWA;
        AppMethodBeat.o(114939);
        return lVar;
    }
}

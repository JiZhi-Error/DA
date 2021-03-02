package com.tencent.mm.plugin.normsg.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.normsg.c;
import com.tencent.mm.sdk.platformtools.Log;

public final class f {
    public static boolean AGj;

    static {
        AppMethodBeat.i(149091);
        AGj = false;
        long nanoTime = System.nanoTime();
        try {
            AGj = c.p.ag();
            Log.i("MicroMsg.NormalMsgSource.DADH", "CDA, result: %b, time: %d ns", Boolean.valueOf(AGj), Long.valueOf(System.nanoTime() - nanoTime));
            AppMethodBeat.o(149091);
        } catch (Throwable th) {
            Log.i("MicroMsg.NormalMsgSource.DADH", "CDA, result: %b, time: %d ns", Boolean.valueOf(AGj), Long.valueOf(System.nanoTime() - nanoTime));
            AppMethodBeat.o(149091);
            throw th;
        }
    }
}

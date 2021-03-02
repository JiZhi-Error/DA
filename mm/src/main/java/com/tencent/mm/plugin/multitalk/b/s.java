package com.tencent.mm.plugin.multitalk.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public final class s {
    public static int cyW() {
        AppMethodBeat.i(239307);
        if (Log.getImpl() != null) {
            int logLevel = Log.getImpl().getLogLevel(0);
            AppMethodBeat.o(239307);
            return logLevel;
        }
        AppMethodBeat.o(239307);
        return 0;
    }
}

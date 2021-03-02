package com.tencent.mm.plugin.cloudvoip.cloudvoice.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public final class c {
    public static int cyW() {
        AppMethodBeat.i(90787);
        if (Log.getImpl() != null) {
            int logLevel = Log.getImpl().getLogLevel(0);
            AppMethodBeat.o(90787);
            return logLevel;
        }
        AppMethodBeat.o(90787);
        return 0;
    }
}

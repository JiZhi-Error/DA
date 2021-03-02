package com.tencent.mm.plugin.sport.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.platformtools.Log;

public final class c {
    public static final void pl(int i2) {
        AppMethodBeat.i(116811);
        Log.v("MicroMsg.Sport.SportReportLogic", "report action=%d", Integer.valueOf(i2));
        e.INSTANCE.a(13168, Integer.valueOf(i2));
        AppMethodBeat.o(116811);
    }
}

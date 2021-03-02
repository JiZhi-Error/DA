package com.tencent.mm.plugin.ae;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.sdk.platformtools.Log;

public final class a {
    private static Boolean JRR = Boolean.FALSE;

    public static boolean dhR() {
        AppMethodBeat.i(263526);
        boolean a2 = ((b) g.af(b.class)).a(b.a.clicfg_timeline_enable_read_data_zero, false);
        if (JRR.booleanValue() != a2) {
            JRR = Boolean.valueOf(a2);
            Log.i("MicroMsg.VideoPlayConfig", "enableReadSampleZero :%b", Boolean.valueOf(a2));
        }
        AppMethodBeat.o(263526);
        return a2;
    }
}

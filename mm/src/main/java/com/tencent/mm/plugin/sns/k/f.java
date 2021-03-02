package com.tencent.mm.plugin.sns.k;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.platformtools.Log;

public final class f {
    public static void s(int i2, String str, int i3) {
        AppMethodBeat.i(125685);
        String format = String.format("%s,%s,%s,%s", Integer.valueOf(i2), str, Integer.valueOf(i3), Long.valueOf(System.currentTimeMillis()));
        Log.i("MicroMsg.SNS.SnsReportLogic", "snsRedDotAction 16172 report %s", format);
        e.INSTANCE.kvStat(16172, format);
        AppMethodBeat.o(125685);
    }
}

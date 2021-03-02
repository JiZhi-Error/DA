package com.tencent.mm.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class y {
    private static String HXc = "";
    private static String Rud = "";
    private static long pWj = 0;

    public static void setTimeStamp(String str) {
        AppMethodBeat.i(72803);
        HXc = str;
        pWj = System.currentTimeMillis() / 1000;
        Rud = Util.getStack().toString();
        AppMethodBeat.o(72803);
    }

    public static String hhp() {
        boolean z = false;
        AppMethodBeat.i(72804);
        if (Util.isNullOrNil(HXc) || CrashReportFactory.hasDebuger()) {
            Object[] objArr = new Object[3];
            objArr[0] = Rud;
            long secondsToNow = Util.secondsToNow(pWj);
            Log.d("MicroMsg.TimeStampHelper", "pass time ".concat(String.valueOf(secondsToNow)));
            if (secondsToNow > 300) {
                z = true;
            }
            objArr[1] = Boolean.valueOf(z);
            objArr[2] = Long.valueOf(pWj);
            Log.i("MicroMsg.TimeStampHelper", "getTimeStamp is null from %s isOverdue %s update_time: %s", objArr);
        }
        String str = HXc;
        AppMethodBeat.o(72804);
        return str;
    }
}

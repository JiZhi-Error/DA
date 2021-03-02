package com.tencent.mm.plugin.sns.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.sdk.platformtools.Log;

public final class b {
    public static String aH(String str, String str2, String str3) {
        AppMethodBeat.i(202552);
        StringBuilder sb = new StringBuilder();
        String valueOf = String.valueOf(System.currentTimeMillis());
        sb.append(valueOf).append(",").append(str).append(",").append(i.aNZ(str2)).append(",,,,").append(str3);
        String sb2 = sb.toString();
        AppMethodBeat.o(202552);
        return sb2;
    }

    public static String A(String str, String str2, String str3, String str4) {
        AppMethodBeat.i(202553);
        StringBuilder sb = new StringBuilder();
        String valueOf = String.valueOf(System.currentTimeMillis());
        sb.append(valueOf).append(",").append(str).append(",").append(str2).append(",").append(i.aNZ(str3)).append(",,,,").append(str4);
        String sb2 = sb.toString();
        AppMethodBeat.o(202553);
        return sb2;
    }

    public static void aI(String str, String str2, String str3) {
        int i2;
        AppMethodBeat.i(202554);
        try {
            if (ab.Eq(str)) {
                i2 = 2;
            } else {
                i2 = 1;
            }
            Log.i("AntiCheatingReportUtils", "shareType = ".concat(String.valueOf(i2)));
            String A = A(String.valueOf(i2), str, str2, str3);
            Log.i("AntiCheatingReportUtils", "reportScreenShotParams = ".concat(String.valueOf(A)));
            h.INSTANCE.kvStat(19214, A);
            AppMethodBeat.o(202554);
        } catch (Throwable th) {
            Log.e("AntiCheatingReportUtils", th.toString());
            AppMethodBeat.o(202554);
        }
    }
}

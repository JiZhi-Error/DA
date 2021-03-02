package com.tencent.mm.plugin.luckymoney.a;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.UUID;

public final class d {
    public static String sessionId;
    public static long startTime;
    public static String yOZ;
    public static boolean yPa = false;

    public static void bFT() {
        AppMethodBeat.i(168791);
        sessionId = UUID.randomUUID().toString();
        startTime = SystemClock.elapsedRealtime() / 1000;
        AppMethodBeat.o(168791);
    }

    public static void aDp(String str) {
        yOZ = str;
    }

    public static void xV(int i2) {
        AppMethodBeat.i(168792);
        if (Util.isNullOrNil(sessionId)) {
            AppMethodBeat.o(168792);
        } else if (yPa || !(i2 == 9 || i2 == 10 || i2 == 11)) {
            if (i2 == 9 || i2 == 10 || i2 == 11) {
                yPa = false;
            }
            long elapsedRealtime = (SystemClock.elapsedRealtime() / 1000) - startTime;
            h.INSTANCE.a(18889, Integer.valueOf(i2), sessionId, Long.valueOf(elapsedRealtime), yOZ);
            AppMethodBeat.o(168792);
        } else {
            AppMethodBeat.o(168792);
        }
    }

    public static void resetSession() {
        sessionId = null;
        yOZ = null;
        startTime = -1;
    }
}

package com.tencent.mm.model;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar;

public final class cl {
    private static volatile boolean iFZ = false;
    private static long iGa = -1;
    private static long iGb = -1;
    private static final Object lock = new Object();

    static {
        AppMethodBeat.i(196998);
        AppMethodBeat.o(196998);
    }

    public static long aWy() {
        long j2 = 0;
        AppMethodBeat.i(132281);
        if (MMApplicationContext.isMainProcess() && g.aAi().hrr) {
            g.aAi();
            if (g.aAf().azp()) {
                try {
                    j2 = aWA();
                    AppMethodBeat.o(132281);
                } catch (Throwable th) {
                    Log.e("MicroMsg.TimeHelper", th.getMessage());
                    AppMethodBeat.o(132281);
                }
                return j2;
            }
        }
        Log.i("MicroMsg.TimeHelper", "account error");
        AppMethodBeat.o(132281);
        return j2;
    }

    public static void Af(long j2) {
        AppMethodBeat.i(132282);
        synchronized (lock) {
            try {
                if (!iFZ) {
                    iGa = j2;
                } else {
                    iGa = Math.max(j2, aWA());
                }
                iGb = SystemClock.elapsedRealtime();
                iFZ = true;
            } catch (Throwable th) {
                AppMethodBeat.o(132282);
                throw th;
            }
        }
        ao azQ = g.aAh().azQ();
        azQ.set(ar.a.USERINFO_CLIENT_SERVER_TIME_LONG, Long.valueOf(iGa));
        azQ.set(ar.a.USERINFO_CLIENT_SERVER_ELAPSED_TIME_LONG, Long.valueOf(iGb));
        AppMethodBeat.o(132282);
    }

    public static long aWz() {
        AppMethodBeat.i(259565);
        long aWA = aWA();
        AppMethodBeat.o(259565);
        return aWA;
    }

    public static long aWA() {
        long max;
        AppMethodBeat.i(162133);
        if (iFZ) {
            synchronized (lock) {
                try {
                    max = Math.max(0L, SystemClock.elapsedRealtime() - iGb) + iGa;
                } finally {
                    AppMethodBeat.o(162133);
                }
            }
            return max;
        }
        long currentTimeMillis = System.currentTimeMillis();
        AppMethodBeat.o(162133);
        return currentTimeMillis;
    }

    public static int aWB() {
        AppMethodBeat.i(132284);
        int aWA = (int) (aWA() / 1000);
        AppMethodBeat.o(132284);
        return aWA;
    }

    public static long secondsToNow(long j2) {
        AppMethodBeat.i(132285);
        long aWA = (aWA() / 1000) - j2;
        AppMethodBeat.o(132285);
        return aWA;
    }
}

package com.tencent.mm.lib.riskscanner;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.af;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

final class a {
    private static ThreadLocal<Long> hvA = new ThreadLocal<>();

    static {
        AppMethodBeat.i(138298);
        AppMethodBeat.o(138298);
    }

    public static void aBA() {
        AppMethodBeat.i(138295);
        Log.i("MicroMsg.RiskScannerReportService", "Report scan triggering.");
        e.INSTANCE.idkeyStat(590, 0, 1, true);
        hvA.set(Long.valueOf(Util.currentTicks()));
        AppMethodBeat.o(138295);
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0070 A[SYNTHETIC, Splitter:B:17:0x0070] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0075 A[SYNTHETIC, Splitter:B:20:0x0075] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0087 A[SYNTHETIC, Splitter:B:28:0x0087] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x008c A[SYNTHETIC, Splitter:B:31:0x008c] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0093  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void f(java.lang.Throwable r11) {
        /*
        // Method dump skipped, instructions count: 171
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.lib.riskscanner.a.f(java.lang.Throwable):void");
    }

    public static void qn(int i2) {
        AppMethodBeat.i(138297);
        Log.i("MicroMsg.RiskScannerReportService", "Report scan result, %d", Integer.valueOf(i2));
        switch (i2) {
            case -10:
                e.INSTANCE.idkeyStat(590, 2, 1, true);
                AppMethodBeat.o(138297);
                return;
            case 0:
                Long l = hvA.get();
                if (l != null) {
                    long currentTicks = Util.currentTicks() - l.longValue();
                    Log.i("MicroMsg.RiskScannerReportService", "Scan cost: %d ms", Long.valueOf(currentTicks));
                    e.INSTANCE.b(af.CTRL_INDEX, 5, 1, (int) currentTicks, true);
                    AppMethodBeat.o(138297);
                    return;
                }
                e.INSTANCE.idkeyStat(590, 1, 1, true);
                AppMethodBeat.o(138297);
                return;
            default:
                e.INSTANCE.idkeyStat(590, 3, 1, true);
                AppMethodBeat.o(138297);
                return;
        }
    }
}

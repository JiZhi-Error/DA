package com.tencent.mm.plugin.expt.d.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;

public final class a {
    private static Boolean syu;
    public static Boolean syv;

    public static void k(String str, int i2, long j2) {
        AppMethodBeat.i(220347);
        if (syu == null) {
            syu = Boolean.valueOf(((b) g.af(b.class)).a(b.a.clicfg_edge_computing_is_monitor_process, false));
            Log.i("EdgeComputingMonitor", "[EdgeComputingMonitor] monitorProcess sIsMonitorProcess : " + syu);
        }
        if (syu.booleanValue()) {
            h.INSTANCE.a(20177, str, Integer.valueOf(i2), Long.valueOf(j2));
        }
        AppMethodBeat.o(220347);
    }

    public static void e(String str, long j2, int i2) {
        AppMethodBeat.i(220348);
        if (j2 <= 10) {
            h.INSTANCE.idkeyStat(1409, 8, 1, false);
        } else if (j2 <= 100) {
            h.INSTANCE.idkeyStat(1409, 9, 1, false);
        } else if (j2 <= 1000) {
            h.INSTANCE.idkeyStat(1409, 10, 1, false);
        } else {
            h.INSTANCE.idkeyStat(1409, 11, 1, false);
            if (syv == null) {
                syv = Boolean.valueOf(((b) g.af(b.class)).a(b.a.clicfg_edge_computing_is_monitor_performance, false));
                Log.i("EdgeComputingMonitor", "[EdgeComputingMonitor] statStorageCostTime sIsMonitorPerformance : " + syv);
            }
            if (syv.booleanValue()) {
                h.INSTANCE.a(20176, str, 2, Long.valueOf(j2), Integer.valueOf(i2));
            }
        }
        Log.d("EdgeComputingMonitor", "[EdgeComputingMonitor] statStorageCostTime configID : %s, costTime : %d, dataSzie : %d", str, Long.valueOf(j2), Integer.valueOf(i2));
        AppMethodBeat.o(220348);
    }

    public static void lT(boolean z) {
        AppMethodBeat.i(220349);
        if (z) {
            h.INSTANCE.idkeyStat(1409, 20, 1, false);
        } else {
            h.INSTANCE.idkeyStat(1409, 21, 1, false);
        }
        Log.d("EdgeComputingMonitor", "[EdgeComputingMonitor] statScriptConfigParseError success : ".concat(String.valueOf(z)));
        AppMethodBeat.o(220349);
    }

    public static void lU(boolean z) {
        AppMethodBeat.i(220350);
        if (z) {
            h.INSTANCE.idkeyStat(1409, 22, 1, false);
        } else {
            h.INSTANCE.idkeyStat(1409, 23, 1, false);
        }
        Log.d("EdgeComputingMonitor", "[EdgeComputingMonitor] statSqlConfigParseError success : ".concat(String.valueOf(z)));
        AppMethodBeat.o(220350);
    }

    public static void lV(boolean z) {
        AppMethodBeat.i(220351);
        if (z) {
            h.INSTANCE.idkeyStat(1409, 24, 1, false);
        } else {
            h.INSTANCE.idkeyStat(1409, 25, 1, false);
        }
        Log.d("EdgeComputingMonitor", "[EdgeComputingMonitor] statV8ScriptEngineInitError success : ".concat(String.valueOf(z)));
        AppMethodBeat.o(220351);
    }
}

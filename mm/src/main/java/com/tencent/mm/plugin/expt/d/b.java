package com.tencent.mm.plugin.expt.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.h.d;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class b {
    private static Boolean sxI;
    private static ThreadPoolExecutor sxJ = new ThreadPoolExecutor(1, 3, 1, TimeUnit.SECONDS, new LinkedBlockingDeque());

    static {
        AppMethodBeat.i(220292);
        AppMethodBeat.o(220292);
    }

    public static ThreadPoolExecutor cMK() {
        return sxJ;
    }

    public static boolean cML() {
        AppMethodBeat.i(220284);
        if (sxI == null) {
            sxI = Boolean.valueOf(((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_edge_computing_cloud_switch, true));
        }
        if (!sxI.booleanValue()) {
            Log.i("EdgeComputingUtils", "[EdgeComputingUtils] isOpenEdgeComputing cloudSwitch isClose!");
            AppMethodBeat.o(220284);
            return false;
        }
        AppMethodBeat.o(220284);
        return true;
    }

    public static MultiProcessMMKV cMM() {
        AppMethodBeat.i(220285);
        StringBuilder sb = new StringBuilder("mmkv_name_edge_computing_default_");
        d.cRY();
        MultiProcessMMKV mmkv = MultiProcessMMKV.getMMKV(sb.append(d.getUin()).toString());
        AppMethodBeat.o(220285);
        return mmkv;
    }

    public static MultiProcessMMKV cMN() {
        AppMethodBeat.i(220286);
        StringBuilder sb = new StringBuilder("mmkv_name_edge_computing_cache_");
        d.cRY();
        MultiProcessMMKV mmkv = MultiProcessMMKV.getMMKV(sb.append(d.getUin()).toString());
        AppMethodBeat.o(220286);
        return mmkv;
    }

    public static MultiProcessMMKV cMO() {
        AppMethodBeat.i(220287);
        StringBuilder sb = new StringBuilder("mmkv_name_edge_computing_instant_cache_");
        d.cRY();
        MultiProcessMMKV mmkv = MultiProcessMMKV.getMMKV(sb.append(d.getUin()).toString());
        AppMethodBeat.o(220287);
        return mmkv;
    }

    public static MultiProcessMMKV cMP() {
        AppMethodBeat.i(220288);
        StringBuilder sb = new StringBuilder("mmkv_name_edge_computing_config_");
        d.cRY();
        MultiProcessMMKV mmkv = MultiProcessMMKV.getMMKV(sb.append(d.getUin()).toString());
        AppMethodBeat.o(220288);
        return mmkv;
    }

    public static MultiProcessMMKV cMQ() {
        AppMethodBeat.i(220289);
        StringBuilder sb = new StringBuilder("mmkv_name_edge_computing_breaker_");
        d.cRY();
        MultiProcessMMKV mmkv = MultiProcessMMKV.getMMKV(sb.append(d.getUin()).toString());
        AppMethodBeat.o(220289);
        return mmkv;
    }

    public static MultiProcessMMKV cMR() {
        AppMethodBeat.i(220290);
        StringBuilder sb = new StringBuilder("mmkv_name_edge_computing_run_record_");
        d.cRY();
        MultiProcessMMKV mmkv = MultiProcessMMKV.getMMKV(sb.append(d.getUin()).toString());
        AppMethodBeat.o(220290);
        return mmkv;
    }

    public static boolean KB() {
        AppMethodBeat.i(220291);
        if (BuildInfo.IS_FLAVOR_PURPLE || BuildInfo.IS_FLAVOR_RED || CrashReportFactory.hasDebuger()) {
            AppMethodBeat.o(220291);
            return true;
        }
        AppMethodBeat.o(220291);
        return false;
    }
}

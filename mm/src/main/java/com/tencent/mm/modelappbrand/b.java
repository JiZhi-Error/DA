package com.tencent.mm.modelappbrand;

import android.content.SharedPreferences;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessSharedPreferences;
import com.tencent.mm.sdk.platformtools.Util;

public final class b {
    public static String iIm;
    public static String iIn;

    public static String aXE() {
        AppMethodBeat.i(153189);
        StringBuilder sb = new StringBuilder("sid_");
        g.aAf();
        iIm = sb.append(a.getUin()).append("_").append(Util.nowMilliSecond()).toString();
        Log.v("MicroMsg.AppBrandReporter", "refreshWeAppSearchSessionId : %s", iIm);
        String str = iIm;
        AppMethodBeat.o(153189);
        return str;
    }

    public static void Lm(String str) {
        AppMethodBeat.i(153190);
        try {
            SharedPreferences.Editor edit = MultiProcessSharedPreferences.getSharedPreferences(MMApplicationContext.getContext(), "pref_appbrand_process", 4).edit();
            edit.remove(str + ":start_time");
            edit.commit();
            e.INSTANCE.idkeyStat(365, 5, 1, false);
            Log.v("MicroMsg.AppBrandReporter", "onProcessExit");
            AppMethodBeat.o(153190);
        } catch (Throwable th) {
            Log.printErrStackTrace("MicroMsg.AppBrandReporter", th, "onProcessExit(%s)", str);
            AppMethodBeat.o(153190);
        }
    }
}

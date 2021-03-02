package com.tencent.mm.app;

import android.content.res.Configuration;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.booter.t;
import com.tencent.mm.compatible.loader.d;
import com.tencent.mm.f.a;
import com.tencent.mm.plugin.report.a.c;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;

public final class PatchProfile extends d {
    public static final String dkO = (MMApplicationContext.getPackageName() + ":patch");

    static {
        AppMethodBeat.i(19464);
        AppMethodBeat.o(19464);
    }

    @Override // com.tencent.mm.compatible.loader.d
    public final void onCreate() {
        AppMethodBeat.i(19463);
        long currentTimeMillis = System.currentTimeMillis();
        t tVar = new t(com.tencent.mm.booter.d.cg(this.app.getBaseContext()));
        tVar.CN("PATCH");
        try {
            int intValue = Integer.decode(tVar.getString(".com.tencent.mm.debug.log.setversion")).intValue();
            com.tencent.mm.protocal.d.aiV(intValue);
            new StringBuilder("set up test protocal version = ").append(Integer.toHexString(intValue));
        } catch (Exception e2) {
            Log.i("MicroMsg.PatchDebugger", "no debugger was got");
        }
        try {
            String string = tVar.getString(".com.tencent.mm.debug.log.setapilevel");
            if (!Util.isNullOrNil(string)) {
                com.tencent.mm.protocal.d.ics = "android-".concat(String.valueOf(string));
                com.tencent.mm.protocal.d.KyK = "android-".concat(String.valueOf(string));
                com.tencent.mm.protocal.d.KyM = String.valueOf(string);
                CrashReportFactory.setDebugerApiLevel(string);
                new StringBuilder("set up test protocal apilevel = ").append(com.tencent.mm.protocal.d.ics).append(" ").append(CrashReportFactory.getDebugerApiLevel());
            }
        } catch (Exception e3) {
            Log.i("MicroMsg.PatchDebugger", "no debugger was got");
        }
        try {
            int intValue2 = Integer.decode(tVar.getString(".com.tencent.mm.debug.log.setuin")).intValue();
            new StringBuilder("set up test protocal uin old: ").append(com.tencent.mm.protocal.d.KyN).append(" new: ").append(intValue2);
            com.tencent.mm.protocal.d.KyN = (long) intValue2;
        } catch (Exception e4) {
            Log.i("MicroMsg.PatchDebugger", "no debugger was got");
        }
        try {
            boolean nullAs = Util.nullAs(tVar.CO(".com.tencent.mm.debug.report.debugmodel"), false);
            boolean nullAs2 = Util.nullAs(tVar.CO(".com.tencent.mm.debug.report.kvstat"), false);
            boolean nullAs3 = Util.nullAs(tVar.CO(".com.tencent.mm.debug.report.clientpref"), false);
            boolean nullAs4 = Util.nullAs(tVar.CO(".com.tencent.mm.debug.report.useraction"), false);
            c.d(nullAs, nullAs2, nullAs3, nullAs4);
            new StringBuilder("try control report : debugModel[").append(nullAs).append("],kv[").append(nullAs2).append("], clientPref[").append(nullAs3).append("], useraction[").append(nullAs4).append("]");
        } catch (Exception e5) {
            Log.i("MicroMsg.PatchDebugger", "no debugger was got");
        }
        a.cc(MMApplicationContext.getContext());
        t.d(false, dkO);
        ab.WH();
        Log.i("MicroMsg.PatchProfile", "patchsprofile try to init hotpatch plugin");
        Log.i("MicroMsg.PatchProfile", "start time check patchsprofile use time = " + (System.currentTimeMillis() - currentTimeMillis));
        AppMethodBeat.o(19463);
    }

    @Override // com.tencent.mm.compatible.loader.d
    public final void onConfigurationChanged(Configuration configuration) {
    }

    public final String toString() {
        return dkO;
    }
}

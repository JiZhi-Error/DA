package com.tencent.mm.app;

import android.content.res.Configuration;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.booter.r;
import com.tencent.mm.compatible.loader.d;
import com.tencent.mm.f.a;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.plugin.report.a.c;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;

public class ExDeviceProfile extends d {
    public static final String dkO = (MMApplicationContext.getPackageName() + ":exdevice");

    static {
        AppMethodBeat.i(19442);
        AppMethodBeat.o(19442);
    }

    @Override // com.tencent.mm.compatible.loader.d
    public final void onCreate() {
        AppMethodBeat.i(19440);
        Log.i("MicroMsg.ExDeviceProfile", "exdevice profile oncreate");
        com.tencent.mm.booter.d cg = com.tencent.mm.booter.d.cg(this.app.getBaseContext());
        a.cc(MMApplicationContext.getContext());
        t.d(false, dkO);
        r rVar = new r(cg);
        rVar.CN("EXDEVICE");
        ac.jNP = Util.nullAs(rVar.CO(".com.tencent.mm.debug.test.display_errcode"), false);
        ac.jNQ = Util.nullAs(rVar.CO(".com.tencent.mm.debug.test.display_msgstate"), false);
        ac.jNR = Util.nullAs(rVar.CO(".com.tencent.mm.debug.test.network.simulate_fault"), false);
        ac.jNS = Util.nullAs(rVar.CO(".com.tencent.mm.debug.test.network.force_touch"), false);
        ac.jNT = Util.nullAs(rVar.CO(".com.tencent.mm.debug.test.outputToSdCardlog"), false);
        ac.jNU = Util.nullAs(rVar.CO(".com.tencent.mm.debug.test.crashIsExit"), false);
        ac.jNY = Util.nullAs(rVar.CO(".com.tencent.mm.debug.test.album_show_info"), false);
        ac.jNZ = Util.nullAs(rVar.CO(".com.tencent.mm.debug.test.location_help"), false);
        ac.jOc = Util.nullAs(rVar.CO(".com.tencent.mm.debug.test.force_soso"), false);
        ac.jOd = Util.nullAs(rVar.CO(".com.tencent.mm.debug.test.simulatePostServerError"), false);
        ac.jOe = Util.nullAs(rVar.CO(".com.tencent.mm.debug.test.simulateUploadServerError"), false);
        ac.jOf = Util.nullAs(rVar.CO(".com.tencent.mm.debug.test.snsNotwirteThumb"), false);
        ac.jOi = Util.nullAs(rVar.CO(".com.tencent.mm.debug.test.filterfpnp"), false);
        ac.jOj = Util.nullAs(rVar.CO(".com.tencent.mm.debug.test.testForPull"), false);
        int nullAs = Util.nullAs(rVar.getInteger(".com.tencent.mm.debug.test.cdnDownloadThread"), 0);
        ac.jOg = nullAs;
        if (nullAs != 4 && ac.jOg > 0) {
            aq.NSc = ac.jOg;
            Log.e("MicroMsg.ExdDebugger", "cdn thread num " + ac.jOg);
        }
        ac.jOh = Util.nullAs(rVar.CO(".com.tencent.mm.debug.test.logShowSnsItemXml"), false);
        try {
            int intValue = Integer.decode(rVar.getString(".com.tencent.mm.debug.log.setversion")).intValue();
            com.tencent.mm.protocal.d.aiV(intValue);
            new StringBuilder("set up test protocal version = ").append(Integer.toHexString(intValue));
        } catch (Exception e2) {
            Log.i("MicroMsg.ExdDebugger", "no debugger was got");
        }
        try {
            String string = rVar.getString(".com.tencent.mm.debug.log.setapilevel");
            if (!Util.isNullOrNil(string)) {
                com.tencent.mm.protocal.d.ics = "android-".concat(String.valueOf(string));
                com.tencent.mm.protocal.d.KyK = "android-".concat(String.valueOf(string));
                com.tencent.mm.protocal.d.KyM = String.valueOf(string);
                CrashReportFactory.setDebugerApiLevel(string);
                new StringBuilder("set up test protocal apilevel = ").append(com.tencent.mm.protocal.d.ics).append(" ").append(CrashReportFactory.getDebugerApiLevel());
            }
        } catch (Exception e3) {
            Log.i("MicroMsg.ExdDebugger", "no debugger was got");
        }
        try {
            int intValue2 = Integer.decode(rVar.getString(".com.tencent.mm.debug.log.setuin")).intValue();
            new StringBuilder("set up test protocal uin old: ").append(com.tencent.mm.protocal.d.KyN).append(" new: ").append(intValue2);
            com.tencent.mm.protocal.d.KyN = (long) intValue2;
        } catch (Exception e4) {
            Log.i("MicroMsg.ExdDebugger", "no debugger was got");
        }
        try {
            boolean nullAs2 = Util.nullAs(rVar.CO(".com.tencent.mm.debug.report.debugmodel"), false);
            boolean nullAs3 = Util.nullAs(rVar.CO(".com.tencent.mm.debug.report.kvstat"), false);
            boolean nullAs4 = Util.nullAs(rVar.CO(".com.tencent.mm.debug.report.clientpref"), false);
            boolean nullAs5 = Util.nullAs(rVar.CO(".com.tencent.mm.debug.report.useraction"), false);
            c.d(nullAs2, nullAs3, nullAs4, nullAs5);
            new StringBuilder("try control report : debugModel[").append(nullAs2).append("],kv[").append(nullAs3).append("], clientPref[").append(nullAs4).append("], useraction[").append(nullAs5).append("]");
        } catch (Exception e5) {
            Log.i("MicroMsg.ExdDebugger", "no debugger was got");
        }
        ac.jOx = Util.nullAs(rVar.getString(".com.tencent.mm.debug.jsapi.permission"), "");
        Log.d("MicroMsg.ExdDebugger", "Test.jsapiPermission = " + ac.jOx);
        ac.jOy = Util.nullAs(rVar.getString(".com.tencent.mm.debug.generalcontrol.permission"), "");
        Log.d("MicroMsg.ExdDebugger", "Test.generalCtrl = " + ac.jOy);
        ac.jOz = Util.nullAs(rVar.CO(".com.tencent.mm.debug.skiploadurlcheck"), false);
        Log.d("MicroMsg.ExdDebugger", "Test.skipLoadUrlCheck = " + ac.jOz);
        ab.WH();
        AppMethodBeat.o(19440);
    }

    @Override // com.tencent.mm.compatible.loader.d
    public final void onConfigurationChanged(Configuration configuration) {
        AppMethodBeat.i(19441);
        Log.d("MicroMsg.ExDeviceProfile", "onConfigurationChanged:" + toString());
        AppMethodBeat.o(19441);
    }

    public String toString() {
        return dkO;
    }
}

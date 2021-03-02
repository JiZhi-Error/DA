package com.tencent.mm.app;

import android.content.res.Configuration;
import com.tencent.mars.Mars;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.booter.p;
import com.tencent.mm.compatible.loader.d;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.console.Shell;
import com.tencent.mm.f.a;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.plugin.report.a.c;
import com.tencent.mm.plugin.report.service.KVCommCrossProcessReceiver;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.CommLibFileName;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMUncaughtExceptionHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.mm.storage.aq;

public class AppBrandProfile extends d {
    protected static String cQi = "";

    @Override // com.tencent.mm.compatible.loader.d
    public final void onCreate() {
        AppMethodBeat.i(19429);
        Log.i("MicroMsg.AppBrandProfile", "AppBrandProfile create");
        cQi = MMApplicationContext.getProcessName();
        AppBrandProfile.class.getClassLoader();
        a.cc(MMApplicationContext.getContext());
        t.addOnUncaughtExceptionListener(new MMUncaughtExceptionHandler.IOnUncaughtExceptionListener() {
            /* class com.tencent.mm.app.AppBrandProfile.AnonymousClass1 */

            @Override // com.tencent.mm.sdk.platformtools.MMUncaughtExceptionHandler.IOnUncaughtExceptionListener
            public final void uncaughtException(MMUncaughtExceptionHandler mMUncaughtExceptionHandler, String str, Throwable th) {
                AppMethodBeat.i(231385);
                h.INSTANCE.idkeyStat(365, 3, 1, false);
                KVCommCrossProcessReceiver.eOD();
                AppMethodBeat.o(231385);
            }
        });
        p pVar = new p(com.tencent.mm.booter.d.cg(this.app.getBaseContext()));
        cQi.replace(MMApplicationContext.getPackageName() + ":appbrand", "");
        ac.jNP = Util.nullAs(pVar.CO(".com.tencent.mm.debug.test.display_errcode"), false);
        ac.jNQ = Util.nullAs(pVar.CO(".com.tencent.mm.debug.test.display_msgstate"), false);
        ac.jNR = Util.nullAs(pVar.CO(".com.tencent.mm.debug.test.network.simulate_fault"), false);
        ac.jNS = Util.nullAs(pVar.CO(".com.tencent.mm.debug.test.network.force_touch"), false);
        ac.jNT = Util.nullAs(pVar.CO(".com.tencent.mm.debug.test.outputToSdCardlog"), false);
        ac.jNU = Util.nullAs(pVar.CO(".com.tencent.mm.debug.test.crashIsExit"), false);
        ac.jNY = Util.nullAs(pVar.CO(".com.tencent.mm.debug.test.album_show_info"), false);
        ac.jNZ = Util.nullAs(pVar.CO(".com.tencent.mm.debug.test.location_help"), false);
        ac.jOc = Util.nullAs(pVar.CO(".com.tencent.mm.debug.test.force_soso"), false);
        ac.jOd = Util.nullAs(pVar.CO(".com.tencent.mm.debug.test.simulatePostServerError"), false);
        ac.jOe = Util.nullAs(pVar.CO(".com.tencent.mm.debug.test.simulateUploadServerError"), false);
        ac.jOf = Util.nullAs(pVar.CO(".com.tencent.mm.debug.test.snsNotwirteThumb"), false);
        ac.jOi = Util.nullAs(pVar.CO(".com.tencent.mm.debug.test.filterfpnp"), false);
        ac.jOj = Util.nullAs(pVar.CO(".com.tencent.mm.debug.test.testForPull"), false);
        int nullAs = Util.nullAs(pVar.getInteger(".com.tencent.mm.debug.test.cdnDownloadThread"), 0);
        ac.jOg = nullAs;
        if (nullAs != 4 && ac.jOg > 0) {
            aq.NSc = ac.jOg;
            Log.e("MicroMsg.AppBDebugger", "cdn thread num " + ac.jOg);
        }
        ac.jOh = Util.nullAs(pVar.CO(".com.tencent.mm.debug.test.logShowSnsItemXml"), false);
        ac.jOA = Util.nullAs(pVar.CO(".com.tencent.mm.debug.forcex5webview"), false);
        ac.jOx = Util.nullAs(pVar.getString(".com.tencent.mm.debug.jsapi.permission"), "");
        Log.d("MicroMsg.AppBDebugger", "Test.jsapiPermission = " + ac.jOx);
        try {
            int intValue = Integer.decode(pVar.getString(".com.tencent.mm.debug.log.setversion")).intValue();
            com.tencent.mm.protocal.d.aiV(intValue);
            new StringBuilder("set up test protocal version = ").append(Integer.toHexString(intValue));
        } catch (Exception e2) {
            Log.i("MicroMsg.AppBDebugger", "no debugger was got");
        }
        try {
            String string = pVar.getString(".com.tencent.mm.debug.log.setapilevel");
            if (!Util.isNullOrNil(string)) {
                com.tencent.mm.protocal.d.ics = "android-".concat(String.valueOf(string));
                com.tencent.mm.protocal.d.KyK = "android-".concat(String.valueOf(string));
                com.tencent.mm.protocal.d.KyM = String.valueOf(string);
                CrashReportFactory.setDebugerApiLevel(string);
                new StringBuilder("set up test protocal apilevel = ").append(com.tencent.mm.protocal.d.ics).append(" ").append(CrashReportFactory.getDebugerApiLevel());
            }
        } catch (Exception e3) {
            Log.i("MicroMsg.AppBDebugger", "no debugger was got");
        }
        try {
            int intValue2 = Integer.decode(pVar.getString(".com.tencent.mm.debug.log.setuin")).intValue();
            new StringBuilder("set up test protocal uin old: ").append(com.tencent.mm.protocal.d.KyN).append(" new: ").append(intValue2);
            com.tencent.mm.protocal.d.KyN = (long) intValue2;
        } catch (Exception e4) {
            Log.i("MicroMsg.AppBDebugger", "no debugger was got");
        }
        try {
            pVar.gmN.glq = Integer.decode(pVar.getString(".com.tencent.mm.debug.log.setchannel")).intValue();
        } catch (Exception e5) {
            Log.i("MicroMsg.AppBDebugger", "no debugger was got");
        }
        try {
            boolean nullAs2 = Util.nullAs(pVar.CO(".com.tencent.mm.debug.report.debugmodel"), false);
            boolean nullAs3 = Util.nullAs(pVar.CO(".com.tencent.mm.debug.report.kvstat"), false);
            boolean nullAs4 = Util.nullAs(pVar.CO(".com.tencent.mm.debug.report.clientpref"), false);
            boolean nullAs5 = Util.nullAs(pVar.CO(".com.tencent.mm.debug.report.useraction"), false);
            c.d(nullAs2, nullAs3, nullAs4, nullAs5);
            new StringBuilder("try control report : debugModel[").append(nullAs2).append("],kv[").append(nullAs3).append("], clientPref[").append(nullAs4).append("], useraction[").append(nullAs5).append("]");
        } catch (Exception e6) {
            Log.i("MicroMsg.AppBDebugger", "no debugger was got");
        }
        if (WeChatEnvironment.hasDebugger()) {
            new Shell().init(MMApplicationContext.getContext());
        }
        a.VP();
        j.Ed("commonimgdec");
        j.Ed("wechatcommon");
        j.Ed(Mars.libMarsBase);
        j.Ed(CommLibFileName.quic);
        j.Ed(Mars.libMarsMM);
        j.Ed("FFmpeg");
        j.Ed("wechatpack");
        ab.WH();
        com.tencent.mm.plugin.appbrand.api.a.kHr = Util.nowMilliSecond();
        com.tencent.mm.cr.d.kT(this.app);
        com.tencent.mm.plugin.appbrand.api.a.kHs = Util.nowMilliSecond();
        EventCenter.instance.addListener(new v(42, 52));
        AppMethodBeat.o(19429);
    }

    @Override // com.tencent.mm.compatible.loader.d
    public final void onConfigurationChanged(Configuration configuration) {
    }

    @Override // com.tencent.mm.compatible.loader.d
    public final void onTrimMemory(int i2) {
        AppMethodBeat.i(19430);
        super.onTrimMemory(i2);
        Log.v("MicroMsg.AppBrandProfile", "onTrimMemory(l : %d)", Integer.valueOf(i2));
        AppMethodBeat.o(19430);
    }
}

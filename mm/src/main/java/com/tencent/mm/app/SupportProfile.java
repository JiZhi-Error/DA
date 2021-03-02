package com.tencent.mm.app;

import android.content.res.Configuration;
import com.tencent.mars.Mars;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.booter.v;
import com.tencent.mm.compatible.deviceinfo.m;
import com.tencent.mm.compatible.loader.d;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.f.a;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.plugin.report.a.c;
import com.tencent.mm.plugin.report.service.KVCommCrossProcessReceiver;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.CommLibFileName;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMUncaughtExceptionHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.ui.MMActivity;
import junit.framework.Assert;

public class SupportProfile extends d {
    protected static String cQi = "";

    @Override // com.tencent.mm.compatible.loader.d
    public final void onCreate() {
        AppMethodBeat.i(19476);
        cQi = MMApplicationContext.getProcessName();
        SupportProfile.class.getClassLoader();
        a.cc(MMApplicationContext.getContext());
        t.addOnUncaughtExceptionListener(new MMUncaughtExceptionHandler.IOnUncaughtExceptionListener() {
            /* class com.tencent.mm.app.SupportProfile.AnonymousClass1 */

            @Override // com.tencent.mm.sdk.platformtools.MMUncaughtExceptionHandler.IOnUncaughtExceptionListener
            public final void uncaughtException(MMUncaughtExceptionHandler mMUncaughtExceptionHandler, String str, Throwable th) {
                AppMethodBeat.i(231389);
                h.INSTANCE.idkeyStat(637, 0, 1, false);
                KVCommCrossProcessReceiver.eOD();
                AppMethodBeat.o(231389);
            }
        });
        v vVar = new v(com.tencent.mm.booter.d.cg(this.app.getBaseContext()));
        vVar.CN("SUPPORT");
        ac.jNP = Util.nullAs(vVar.CO(".com.tencent.mm.debug.test.display_errcode"), false);
        ac.jNQ = Util.nullAs(vVar.CO(".com.tencent.mm.debug.test.display_msgstate"), false);
        ac.jNR = Util.nullAs(vVar.CO(".com.tencent.mm.debug.test.network.simulate_fault"), false);
        ac.jNS = Util.nullAs(vVar.CO(".com.tencent.mm.debug.test.network.force_touch"), false);
        ac.jNT = Util.nullAs(vVar.CO(".com.tencent.mm.debug.test.outputToSdCardlog"), false);
        ac.jNU = Util.nullAs(vVar.CO(".com.tencent.mm.debug.test.crashIsExit"), false);
        ac.jNY = Util.nullAs(vVar.CO(".com.tencent.mm.debug.test.album_show_info"), false);
        ac.jNZ = Util.nullAs(vVar.CO(".com.tencent.mm.debug.test.location_help"), false);
        ac.jOc = Util.nullAs(vVar.CO(".com.tencent.mm.debug.test.force_soso"), false);
        ac.jOd = Util.nullAs(vVar.CO(".com.tencent.mm.debug.test.simulatePostServerError"), false);
        ac.jOe = Util.nullAs(vVar.CO(".com.tencent.mm.debug.test.simulateUploadServerError"), false);
        ac.jOf = Util.nullAs(vVar.CO(".com.tencent.mm.debug.test.snsNotwirteThumb"), false);
        ac.jOi = Util.nullAs(vVar.CO(".com.tencent.mm.debug.test.filterfpnp"), false);
        ac.jOj = Util.nullAs(vVar.CO(".com.tencent.mm.debug.test.testForPull"), false);
        int nullAs = Util.nullAs(vVar.getInteger(".com.tencent.mm.debug.test.cdnDownloadThread"), 0);
        ac.jOg = nullAs;
        if (nullAs != 4 && ac.jOg > 0) {
            aq.NSc = ac.jOg;
            Log.e("SetupSupportDebugger", "cdn thread num " + ac.jOg);
        }
        ac.jOh = Util.nullAs(vVar.CO(".com.tencent.mm.debug.test.logShowSnsItemXml"), false);
        ac.jOA = Util.nullAs(vVar.CO(".com.tencent.mm.debug.forcex5webview"), false);
        ac.jOx = Util.nullAs(vVar.getString(".com.tencent.mm.debug.jsapi.permission"), "");
        Log.d("SetupSupportDebugger", "Test.jsapiPermission = " + ac.jOx);
        try {
            int intValue = Integer.decode(vVar.getString(".com.tencent.mm.debug.log.setversion")).intValue();
            com.tencent.mm.protocal.d.aiV(intValue);
            new StringBuilder("set up test protocal version = ").append(Integer.toHexString(intValue));
        } catch (Exception e2) {
            Log.i("SetupSupportDebugger", "no debugger was got");
        }
        try {
            String string = vVar.getString(".com.tencent.mm.debug.log.setapilevel");
            if (!Util.isNullOrNil(string)) {
                com.tencent.mm.protocal.d.ics = "android-".concat(String.valueOf(string));
                com.tencent.mm.protocal.d.KyK = "android-".concat(String.valueOf(string));
                com.tencent.mm.protocal.d.KyM = String.valueOf(string);
                CrashReportFactory.setDebugerApiLevel(string);
                new StringBuilder("set up test protocal apilevel = ").append(com.tencent.mm.protocal.d.ics).append(" ").append(CrashReportFactory.getDebugerApiLevel());
            }
        } catch (Exception e3) {
            Log.i("SetupSupportDebugger", "no debugger was got");
        }
        try {
            int intValue2 = Integer.decode(vVar.getString(".com.tencent.mm.debug.log.setuin")).intValue();
            new StringBuilder("set up test protocal uin old: ").append(com.tencent.mm.protocal.d.KyN).append(" new: ").append(intValue2);
            com.tencent.mm.protocal.d.KyN = (long) intValue2;
        } catch (Exception e4) {
            Log.i("SetupSupportDebugger", "no debugger was got");
        }
        try {
            vVar.gmN.glq = Integer.decode(vVar.getString(".com.tencent.mm.debug.log.setchannel")).intValue();
        } catch (Exception e5) {
            Log.i("SetupSupportDebugger", "no debugger was got");
        }
        try {
            boolean nullAs2 = Util.nullAs(vVar.CO(".com.tencent.mm.debug.report.debugmodel"), false);
            boolean nullAs3 = Util.nullAs(vVar.CO(".com.tencent.mm.debug.report.kvstat"), false);
            boolean nullAs4 = Util.nullAs(vVar.CO(".com.tencent.mm.debug.report.clientpref"), false);
            boolean nullAs5 = Util.nullAs(vVar.CO(".com.tencent.mm.debug.report.useraction"), false);
            c.d(nullAs2, nullAs3, nullAs4, nullAs5);
            new StringBuilder("try control report : debugModel[").append(nullAs2).append("],kv[").append(nullAs3).append("], clientPref[").append(nullAs4).append("], useraction[").append(nullAs5).append("]");
        } catch (Exception e6) {
            Log.i("SetupSupportDebugger", "no debugger was got");
        }
        t.d(false, cQi);
        a.VP();
        j.Ed("wcdb");
        j.Ed("commonimgdec");
        j.Ed("wechatcommon");
        j.Ed(Mars.libMarsBase);
        j.Ed(CommLibFileName.quic);
        j.Ed(Mars.libMarsMM);
        j.Ed("FFmpeg");
        j.Ed("wechatpack");
        int aon = m.aon();
        if ((aon & 1024) != 0) {
            Log.i("MicroMsg.SupportProfile", "load wechatsight_v7a, core number: %d", Integer.valueOf(aon >> 12));
            j.Ed("wechatsight_v7a");
            if ((aon >> 12) >= 4) {
                com.tencent.mm.plugin.sight.base.c.Dma = 3;
                com.tencent.mm.plugin.sight.base.c.Dmc = 3;
                com.tencent.mm.plugin.sight.base.c.Dmd = 544000;
            } else {
                com.tencent.mm.plugin.sight.base.c.Dma = 1;
                com.tencent.mm.plugin.sight.base.c.Dmc = 1;
                com.tencent.mm.plugin.sight.base.c.Dmd = 640000;
            }
        } else {
            Log.i("MicroMsg.SupportProfile", "load wechatsight");
            j.Ed("wechatsight");
            Assert.assertTrue("Can't remove libwechatsight.so yet.", false);
            com.tencent.mm.plugin.sight.base.c.Dma = 1;
            com.tencent.mm.plugin.sight.base.c.Dmc = 1;
            com.tencent.mm.plugin.sight.base.c.Dmd = 640000;
        }
        a.cc(MMApplicationContext.getContext());
        ab.WH();
        MMActivity.initLanguage(this.app.getBaseContext());
        AppMethodBeat.o(19476);
    }

    @Override // com.tencent.mm.compatible.loader.d
    public final void onConfigurationChanged(Configuration configuration) {
    }

    @Override // com.tencent.mm.compatible.loader.d
    public final void onTrimMemory(int i2) {
        AppMethodBeat.i(19477);
        super.onTrimMemory(i2);
        Log.v("MicroMsg.SupportProfile", "onTrimMemory(l : %d)", Integer.valueOf(i2));
        AppMethodBeat.o(19477);
    }
}

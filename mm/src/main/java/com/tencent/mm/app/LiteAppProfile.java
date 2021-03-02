package com.tencent.mm.app;

import android.app.Application;
import android.content.res.Configuration;
import com.tencent.mars.Mars;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.booter.s;
import com.tencent.mm.compatible.loader.d;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.kernel.g;
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
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\nH\u0016J\u0010\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006¨\u0006\u0011"}, hxF = {"Lcom/tencent/mm/app/LiteAppProfile;", "Lcom/tencent/mm/compatible/loader/Profile;", "()V", "PROCESS_NAME", "", "getPROCESS_NAME", "()Ljava/lang/String;", "TAG", "getTAG", "onConfigurationChanged", "", "config", "Landroid/content/res/Configuration;", "onCreate", "onTrimMemory", "level", "", "app_release"})
public final class LiteAppProfile extends d {
    private final String TAG = "MicroMsg.LiteAppProfile";
    private final String dkO = (MMApplicationContext.getProcessName() + ":lite");

    public LiteAppProfile() {
        AppMethodBeat.i(230595);
        AppMethodBeat.o(230595);
    }

    @Override // com.tencent.mm.compatible.loader.d
    public final void onCreate() {
        AppMethodBeat.i(230592);
        Log.i(this.TAG, "LiteAppProfile onCreate.");
        long currentTimeMillis = System.currentTimeMillis();
        Application application = this.app;
        p.g(application, "app");
        com.tencent.mm.booter.d cg = com.tencent.mm.booter.d.cg(application.getBaseContext());
        p.g(cg, "debugger");
        s sVar = new s(cg);
        sVar.CN("LITE");
        ac.jNP = Util.nullAs(sVar.CO(".com.tencent.mm.debug.test.display_errcode"), false);
        ac.jNQ = Util.nullAs(sVar.CO(".com.tencent.mm.debug.test.display_msgstate"), false);
        ac.jNR = Util.nullAs(sVar.CO(".com.tencent.mm.debug.test.network.simulate_fault"), false);
        ac.jNS = Util.nullAs(sVar.CO(".com.tencent.mm.debug.test.network.force_touch"), false);
        ac.jNT = Util.nullAs(sVar.CO(".com.tencent.mm.debug.test.outputToSdCardlog"), false);
        ac.jNU = Util.nullAs(sVar.CO(".com.tencent.mm.debug.test.crashIsExit"), false);
        ac.jNY = Util.nullAs(sVar.CO(".com.tencent.mm.debug.test.album_show_info"), false);
        ac.jNZ = Util.nullAs(sVar.CO(".com.tencent.mm.debug.test.location_help"), false);
        ac.jOc = Util.nullAs(sVar.CO(".com.tencent.mm.debug.test.force_soso"), false);
        ac.jOd = Util.nullAs(sVar.CO(".com.tencent.mm.debug.test.simulatePostServerError"), false);
        ac.jOe = Util.nullAs(sVar.CO(".com.tencent.mm.debug.test.simulateUploadServerError"), false);
        ac.jOf = Util.nullAs(sVar.CO(".com.tencent.mm.debug.test.snsNotwirteThumb"), false);
        ac.jOi = Util.nullAs(sVar.CO(".com.tencent.mm.debug.test.filterfpnp"), false);
        ac.jOj = Util.nullAs(sVar.CO(".com.tencent.mm.debug.test.testForPull"), false);
        int nullAs = Util.nullAs(sVar.getInteger(".com.tencent.mm.debug.test.cdnDownloadThread"), 0);
        ac.jOg = nullAs;
        if (nullAs != 4 && ac.jOg > 0) {
            aq.NSc = ac.jOg;
            Log.e(sVar.TAG, "cdn thread num " + ac.jOg);
        }
        ac.jOh = Util.nullAs(sVar.CO(".com.tencent.mm.debug.test.logShowSnsItemXml"), false);
        try {
            Integer decode = Integer.decode(sVar.getString(".com.tencent.mm.debug.log.setversion"));
            p.g(decode, "Integer.decode(getString…m.debug.log.setversion\"))");
            int intValue = decode.intValue();
            com.tencent.mm.protocal.d.aiV(intValue);
            new StringBuilder("set up test protocal version = ").append(Integer.toHexString(intValue));
        } catch (Exception e2) {
            Log.i(sVar.TAG, "no debugger was got");
        }
        try {
            String string = sVar.getString(".com.tencent.mm.debug.log.setapilevel");
            if (!Util.isNullOrNil(string)) {
                com.tencent.mm.protocal.d.ics = "android-".concat(String.valueOf(string));
                com.tencent.mm.protocal.d.KyK = "android-".concat(String.valueOf(string));
                com.tencent.mm.protocal.d.KyM = String.valueOf(string);
                CrashReportFactory.setDebugerApiLevel(string);
                new StringBuilder("set up test protocal apilevel = ").append(com.tencent.mm.protocal.d.ics).append(" ").append(CrashReportFactory.getDebugerApiLevel());
            }
        } catch (Exception e3) {
            Log.i(sVar.TAG, "no debugger was got");
        }
        try {
            Integer decode2 = Integer.decode(sVar.getString(".com.tencent.mm.debug.log.setuin"));
            p.g(decode2, "Integer.decode(getString…nt.mm.debug.log.setuin\"))");
            int intValue2 = decode2.intValue();
            new StringBuilder("set up test protocal uin old: ").append(com.tencent.mm.protocal.d.KyN).append(" new: ").append(intValue2);
            com.tencent.mm.protocal.d.KyN = (long) intValue2;
        } catch (Exception e4) {
            Log.i(sVar.TAG, "no debugger was got");
        }
        try {
            Integer decode3 = Integer.decode(sVar.getString(".com.tencent.mm.debug.log.setchannel"));
            p.g(decode3, "Integer.decode(getString…m.debug.log.setchannel\"))");
            sVar.akX().glq = decode3.intValue();
        } catch (Exception e5) {
            Log.i(sVar.TAG, "no debugger was got");
        }
        try {
            boolean nullAs2 = Util.nullAs(sVar.CO(".com.tencent.mm.debug.report.debugmodel"), false);
            boolean nullAs3 = Util.nullAs(sVar.CO(".com.tencent.mm.debug.report.kvstat"), false);
            boolean nullAs4 = Util.nullAs(sVar.CO(".com.tencent.mm.debug.report.clientpref"), false);
            boolean nullAs5 = Util.nullAs(sVar.CO(".com.tencent.mm.debug.report.useraction"), false);
            c.d(nullAs2, nullAs3, nullAs4, nullAs5);
            new StringBuilder("try control report : debugModel[").append(nullAs2).append("],kv[").append(nullAs3).append("], clientPref[").append(nullAs4).append("], useraction[").append(nullAs5).append(']');
        } catch (Exception e6) {
            Log.i(sVar.TAG, "no debugger was got");
        }
        ac.jOx = Util.nullAs(sVar.getString(".com.tencent.mm.debug.jsapi.permission"), "");
        Log.d(sVar.TAG, "Test.jsapiPermission = " + ac.jOx);
        ac.jOy = Util.nullAs(sVar.getString(".com.tencent.mm.debug.generalcontrol.permission"), "");
        Log.d(sVar.TAG, "Test.generalCtrl = " + ac.jOy);
        ac.jOz = Util.nullAs(sVar.CO(".com.tencent.mm.debug.skiploadurlcheck"), false);
        Log.d(sVar.TAG, "Test.skipLoadUrlCheck = " + ac.jOz);
        ac.jOA = Util.nullAs(sVar.CO(".com.tencent.mm.debug.forcex5webview"), false);
        Log.d(sVar.TAG, "Test.forceX5WebView = " + ac.jOA);
        f.bF(g.aAe().azG().aAZ());
        com.tencent.mm.f.a.cc(MMApplicationContext.getContext());
        t.addOnUncaughtExceptionListener(new a());
        t.d(false, this.dkO);
        ab.WH();
        a.VP();
        LiteAppProfile.class.getClassLoader();
        j.load("wechatxlog");
        j.Ed("wechatcommon");
        j.Ed(Mars.libMarsBase);
        j.Ed(Mars.libMarsMM);
        j.Ed(CommLibFileName.quic);
        j.load("wechatlv");
        j.load("liteapphelper");
        Log.i(this.TAG, "LiteAppProfile onCreate finish in %d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        AppMethodBeat.o(230592);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, hxF = {"com/tencent/mm/app/LiteAppProfile$onCreate$1", "Lcom/tencent/mm/sdk/platformtools/MMUncaughtExceptionHandler$IOnUncaughtExceptionListener;", "uncaughtException", "", "ueh", "Lcom/tencent/mm/sdk/platformtools/MMUncaughtExceptionHandler;", "msg", "", "ex", "", "app_release"})
    public static final class a implements MMUncaughtExceptionHandler.IOnUncaughtExceptionListener {
        a() {
        }

        @Override // com.tencent.mm.sdk.platformtools.MMUncaughtExceptionHandler.IOnUncaughtExceptionListener
        public final void uncaughtException(MMUncaughtExceptionHandler mMUncaughtExceptionHandler, String str, Throwable th) {
            AppMethodBeat.i(230591);
            p.h(mMUncaughtExceptionHandler, "ueh");
            p.h(str, "msg");
            p.h(th, "ex");
            h.INSTANCE.n(1293, 3, 1);
            KVCommCrossProcessReceiver.eOD();
            AppMethodBeat.o(230591);
        }
    }

    @Override // com.tencent.mm.compatible.loader.d
    public final void onConfigurationChanged(Configuration configuration) {
        AppMethodBeat.i(230593);
        p.h(configuration, "config");
        Log.i(this.TAG, "onConfigurationChanged");
        AppMethodBeat.o(230593);
    }

    @Override // com.tencent.mm.compatible.loader.d
    public final void onTrimMemory(int i2) {
        AppMethodBeat.i(230594);
        super.onTrimMemory(i2);
        Log.v(this.TAG, "onTerminate(l : %d)", Integer.valueOf(i2));
        AppMethodBeat.o(230594);
    }
}

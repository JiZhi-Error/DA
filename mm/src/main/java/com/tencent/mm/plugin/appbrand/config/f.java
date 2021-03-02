package com.tencent.mm.plugin.appbrand.config;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.luggage.a.e;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.luggage.sdk.config.AppBrandSysConfigLU;
import com.tencent.luggage.sdk.d.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.bw.b;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.ac.i;
import com.tencent.mm.plugin.appbrand.appcache.j;
import com.tencent.mm.plugin.appbrand.s.a;
import com.tencent.mm.plugin.appbrand.utils.x;
import com.tencent.mm.protocal.protobuf.clx;
import com.tencent.mm.sdk.http.HttpWrapperBase;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;

public final class f {
    private static final String czw = WeChatHosts.domainString(R.string.e2b);

    public static a a(d dVar) {
        boolean z;
        boolean z2;
        int i2;
        AppMethodBeat.i(229876);
        AppBrandInitConfigLU ON = dVar.ON();
        AppBrandSysConfigLU OM = dVar.OM();
        b appConfig = dVar.getAppConfig();
        a aVar = new a();
        if (ON.Nx() || ON.NA()) {
            z = true;
        } else {
            z = false;
        }
        aVar.nhC = z;
        boolean z3 = OM.leE.kNW == 1 || OM.leE.kNW == 2;
        if (OM.cyp) {
            z2 = !z3 || !OM.cyF;
        } else {
            z2 = !z3 || !OM.cyC;
        }
        aVar.nhD = z2;
        int i3 = appConfig.lbO.egB;
        if (i3 > 0) {
            aVar.nhE = i3;
        }
        int i4 = appConfig.lbO.lce;
        if (i4 > 0) {
            aVar.nhF = i4;
        }
        int i5 = appConfig.lbO.lcf;
        if (i5 > 0) {
            aVar.nhG = i5;
        }
        int i6 = appConfig.lbO.lcg;
        if (i6 > 0) {
            aVar.nhH = i6;
        }
        aVar.cyK = OM.cyK;
        aVar.nhI = OM.cyN;
        aVar.cyL = OM.cyL;
        aVar.cyM = OM.cyM;
        aVar.cyT = OM.cyT;
        aVar.cyU = OM.cyU;
        aVar.cyV = OM.cyV;
        aVar.cyW = OM.cyW;
        aVar.cyX = OM.cyX;
        if (OM.czd.lcS.mode == 1) {
            if (OM.czd.lcS.ldu != null) {
                aVar.nhJ = OM.czd.lcS.ldu;
            }
        } else if (OM.czd.lcS.mode == 2 && OM.czd.lcS.ldv != null) {
            aVar.nhK = OM.czd.lcS.ldv;
        }
        aVar.mode = OM.czd.lcS.mode;
        aVar.nhL = P(dVar);
        if (ON.NA()) {
            i2 = OM.czd.lde;
        } else {
            i2 = OM.czd.lcM;
        }
        aVar.lcM = i2;
        aVar.cyP = OM.cyP;
        aVar.cyQ = OM.cyQ;
        aVar.nhM = s.aa(MMApplicationContext.getContext(), j.bzW());
        Log.i("Luggage.FULL.AppBrandConfigAdapter", "runtime(%s).getNetworkConfig.userAgentString = [ %s ]", dVar.mAppId, aVar.nhM);
        com.tencent.mm.plugin.appbrand.jsapi.u.a aVar2 = (com.tencent.mm.plugin.appbrand.jsapi.u.a) e.M(com.tencent.mm.plugin.appbrand.jsapi.u.a.class);
        if (aVar2 != null) {
            aVar.nhN = aVar2.aaF(appConfig.iJP);
        } else {
            Log.w("", "getNetworkConfig, referrerHelper is null");
        }
        String str = "";
        if (!(OM.czd == null || OM.czd.lcS == null)) {
            str = OM.czd.lcS.ldA;
        }
        if (Util.isNullOrNil(str)) {
            str = czw;
        }
        aVar.referer = HttpWrapperBase.PROTOCAL_HTTPS + str + FilePathGenerator.ANDROID_DIR_SEP + OM.appId + FilePathGenerator.ANDROID_DIR_SEP + OM.leE.pkgVersion + "/page-frame.html";
        aVar.cyp = ON.cyp;
        aVar.nhO = j.a.sE(OM.leE.kNW);
        if (aVar.nhO || !Util.isNullOrNil(aVar.nhL)) {
            com.tencent.mm.plugin.appbrand.s.j.b(aVar);
        }
        AppMethodBeat.o(229876);
        return aVar;
    }

    public static com.tencent.mm.plugin.appbrand.a.a b(d dVar) {
        AppMethodBeat.i(229877);
        AppBrandSysConfigLU OM = dVar.OM();
        b appConfig = dVar.getAppConfig();
        com.tencent.mm.plugin.appbrand.a.a aVar = new com.tencent.mm.plugin.appbrand.a.a();
        if (OM == null || appConfig == null) {
            AppMethodBeat.o(229877);
        } else {
            if (j.a.sE(OM.leE.kNW)) {
                aVar.kQF = appConfig.lbS.contains(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE);
                aVar.kQG = appConfig.lbS.contains(FirebaseAnalytics.b.LOCATION);
            } else {
                aVar.kQF = OM.ley;
                aVar.kQG = OM.lez;
            }
            AppMethodBeat.o(229877);
        }
        return aVar;
    }

    private static ArrayList<byte[]> P(AppBrandRuntime appBrandRuntime) {
        AppMethodBeat.i(146963);
        ArrayList<byte[]> arrayList = new ArrayList<>();
        i<ByteBuffer> iVar = new i<>();
        appBrandRuntime.getFileSystem().b("cer", iVar);
        if (iVar.value == null) {
            AppMethodBeat.o(146963);
            return arrayList;
        }
        byte[] p = com.tencent.mm.plugin.appbrand.ac.d.p(iVar.value);
        try {
            clx clx = new clx();
            clx.parseFrom(p);
            if (clx.Mrl == null) {
                AppMethodBeat.o(146963);
                return arrayList;
            }
            Iterator<b> it = clx.Mrl.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().zy);
            }
            AppMethodBeat.o(146963);
            return arrayList;
        } catch (Exception e2) {
            Log.e("", "readPkgCertificate, parse error: ".concat(String.valueOf(e2)));
        }
    }

    public static com.tencent.mm.plugin.appbrand.jsapi.file.d a(AppBrandSysConfigLU appBrandSysConfigLU) {
        AppMethodBeat.i(146964);
        com.tencent.mm.plugin.appbrand.jsapi.file.d dVar = new com.tencent.mm.plugin.appbrand.jsapi.file.d();
        dVar.cyR = appBrandSysConfigLU.cyR;
        if (dVar.cyR <= 0) {
            dVar.cyR = 10;
        }
        dVar.ldl = appBrandSysConfigLU.czd.ldl;
        if (dVar.ldl <= 0) {
            dVar.ldl = 30;
        }
        AppMethodBeat.o(146964);
        return dVar;
    }

    public static x.a b(AppBrandSysConfigLU appBrandSysConfigLU) {
        AppMethodBeat.i(229878);
        x.a aVar = new x.a();
        aVar.ldb = appBrandSysConfigLU.czd.ldb;
        AppMethodBeat.o(229878);
        return aVar;
    }

    public static com.tencent.mm.plugin.appbrand.performance.a c(AppBrandSysConfigLU appBrandSysConfigLU) {
        boolean z;
        boolean z2 = true;
        AppMethodBeat.i(229879);
        com.tencent.mm.plugin.appbrand.performance.a aVar = new com.tencent.mm.plugin.appbrand.performance.a();
        if (!appBrandSysConfigLU.cyD || !(appBrandSysConfigLU.leE.kNW == 1 || appBrandSysConfigLU.leE.kNW == 2 || WeChatEnvironment.hasDebugger())) {
            z = false;
        } else {
            z = true;
        }
        aVar.nwy = z;
        if (appBrandSysConfigLU.leE.kNW == 0) {
            z2 = false;
        }
        aVar.nwz = z2;
        aVar.nwA = appBrandSysConfigLU.cyC;
        AppMethodBeat.o(229879);
        return aVar;
    }

    static {
        AppMethodBeat.i(229880);
        AppMethodBeat.o(229880);
    }
}

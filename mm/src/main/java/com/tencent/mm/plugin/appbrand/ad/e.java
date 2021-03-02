package com.tencent.mm.plugin.appbrand.ad;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.mq;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.ad.a.b;
import com.tencent.mm.plugin.appbrand.ad.a.c;
import com.tencent.mm.plugin.appbrand.ad.a.d;
import com.tencent.mm.plugin.appbrand.ad.a.f;
import com.tencent.mm.plugin.appbrand.ad.ui.AppBrandAdUI;
import com.tencent.mm.plugin.appbrand.ad.ui.AppBrandAdUI1;
import com.tencent.mm.plugin.appbrand.ad.ui.AppBrandAdUI2;
import com.tencent.mm.plugin.appbrand.ad.ui.AppBrandAdUI3;
import com.tencent.mm.plugin.appbrand.ad.ui.AppBrandAdUI4;
import com.tencent.mm.plugin.appbrand.appstorage.q;
import com.tencent.mm.plugin.appbrand.appstorage.z;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.jsapi.ac.e;
import com.tencent.mm.plugin.appbrand.jsapi.file.at;
import com.tencent.mm.plugin.appbrand.p;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySession;
import com.tencent.mm.plugin.appbrand.task.e;
import com.tencent.mm.plugin.appbrand.task.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.tmassistantsdk.downloadservice.DownloadHelper;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public final class e {
    private static final Map<String, Class<? extends AppBrandAdUI>> kGI;
    private static Set<String> kGJ;

    static {
        AppMethodBeat.i(44039);
        HashMap hashMap = new HashMap();
        hashMap.put(":appbrand0", AppBrandAdUI.class);
        hashMap.put(":appbrand1", AppBrandAdUI1.class);
        hashMap.put(":appbrand2", AppBrandAdUI2.class);
        hashMap.put(":appbrand3", AppBrandAdUI3.class);
        hashMap.put(":appbrand4", AppBrandAdUI4.class);
        kGI = Collections.unmodifiableMap(hashMap);
        HashSet hashSet = new HashSet();
        kGJ = hashSet;
        hashSet.add(f.NAME);
        kGJ.add(com.tencent.mm.plugin.appbrand.ad.a.e.NAME);
        kGJ.add(d.NAME);
        kGJ.add(c.NAME);
        kGJ.add(b.NAME);
        kGJ.add(e.c.NAME);
        kGJ.add(e.C0599e.NAME);
        kGJ.add(e.b.NAME);
        kGJ.add(e.d.NAME);
        kGJ.add(e.a.NAME);
        AppMethodBeat.o(44039);
    }

    /* access modifiers changed from: package-private */
    public static class a {
        private static final z kGL;

        static {
            AppMethodBeat.i(174693);
            z zVar = new z(at.o("__ad"), "wxfile://ad");
            kGL = zVar;
            zVar.kTk = DownloadHelper.SAVE_LENGTH;
            AppMethodBeat.o(174693);
        }
    }

    public static q btJ() {
        AppMethodBeat.i(174694);
        z zVar = a.kGL;
        AppMethodBeat.o(174694);
        return zVar;
    }

    public static boolean Ux(String str) {
        AppMethodBeat.i(44025);
        boolean contains = kGJ.contains(str);
        AppMethodBeat.o(44025);
        return contains;
    }

    public static boolean H(AppBrandRuntime appBrandRuntime) {
        boolean z;
        AppMethodBeat.i(44026);
        if (!b.btF()) {
            Log.i("MicroMsg.AppBrandAdUtils[AppBrandSplashAd]", "checkCanShowAd, showad experiment closed");
            AppMethodBeat.o(44026);
            return false;
        } else if (!(appBrandRuntime instanceof com.tencent.mm.plugin.appbrand.q)) {
            Log.i("MicroMsg.AppBrandAdUtils[AppBrandSplashAd]", "checkCanShowAd, wrong runtime");
            AppMethodBeat.o(44026);
            return false;
        } else {
            com.tencent.mm.plugin.appbrand.q qVar = (com.tencent.mm.plugin.appbrand.q) appBrandRuntime;
            if (com.tencent.mm.plugin.appbrand.q.bsK() <= 0) {
                Log.i("MicroMsg.AppBrandAdUtils[AppBrandSplashAd]", "checkCanShowAd, timeThreshold invalid");
                AppMethodBeat.o(44026);
                return false;
            }
            if (!(com.tencent.mm.plugin.appbrand.task.e.j(g.iD(qVar.bsC().NA())) != null)) {
                Log.i("MicroMsg.AppBrandAdUtils[AppBrandSplashAd]", "checkCanShowAd, process not preloaded");
                AppMethodBeat.o(44026);
                return false;
            } else if (qVar.bsr()) {
                Log.i("MicroMsg.AppBrandAdUtils[AppBrandSplashAd]", "checkCanShowAd, ignore plugin app, appId:%s", qVar.mAppId);
                AppMethodBeat.o(44026);
                return false;
            } else {
                int i2 = qVar.ON().cyA.scene;
                if (!b.vL(i2)) {
                    Log.i("MicroMsg.AppBrandAdUtils[AppBrandSplashAd]", "checkCanShowAd, scene not fit:%s", Integer.valueOf(i2));
                    AppMethodBeat.o(44026);
                    return false;
                }
                if (!b.btF()) {
                    Log.i("MicroMsg.AppBrandAdUtils[AppBrandSplashAd]", "isAdContact, showad experiment closed");
                    z = false;
                } else if (qVar == null || !(qVar.OU() instanceof AppBrandInitConfigWC)) {
                    Log.i("MicroMsg.AppBrandAdUtils[AppBrandSplashAd]", "isAdContact, null runtime or wrong initConfig");
                    z = false;
                } else {
                    z = ((AppBrandInitConfigWC) qVar.OU()).ldY;
                    if (b.btH()) {
                        Log.i("MicroMsg.AppBrandAdUtils[AppBrandSplashAd]", "isAdContact, set to all show ad");
                        z = true;
                    }
                    Log.i("MicroMsg.AppBrandAdUtils[AppBrandSplashAd]", "isAdContact, appId:%s, canShowAd:%s", qVar.mAppId, Boolean.valueOf(z));
                }
                if (!z) {
                    Log.i("MicroMsg.AppBrandAdUtils[AppBrandSplashAd]", "checkCanShowAd, not ad contact, appId:%s", qVar.mAppId);
                    AppMethodBeat.o(44026);
                    return false;
                }
                AppMethodBeat.o(44026);
                return true;
            }
        }
    }

    public static void a(com.tencent.mm.plugin.appbrand.q qVar, e.c cVar, boolean z) {
        int i2;
        int i3 = 1;
        AppMethodBeat.i(226258);
        switch (cVar) {
            case NOT_PRELOAD:
                i2 = 1;
                break;
            case PRELOADING:
                i2 = 2;
                break;
            case PRELOADED_FULL:
            case PRELOADED_DOWNGRADE:
                i2 = 3;
                break;
            default:
                i2 = 1;
                break;
        }
        QualitySession qualitySession = new QualitySession("", qVar.bsC(), qVar.ON().cyA);
        h hVar = h.INSTANCE;
        Object[] objArr = new Object[7];
        objArr[0] = qualitySession.appId;
        objArr[1] = Integer.valueOf(qualitySession.nLk);
        objArr[2] = mq.a.mB(qualitySession.nJE);
        objArr[3] = Integer.valueOf(qualitySession.apptype);
        objArr[4] = Integer.valueOf(qualitySession.scene);
        objArr[5] = Integer.valueOf(i2);
        if (!z) {
            i3 = 0;
        }
        objArr[6] = Integer.valueOf(i3);
        hVar.a(21052, objArr);
        AppMethodBeat.o(226258);
    }

    public static void c(ac acVar) {
        AppMethodBeat.i(44028);
        if (acVar != null) {
            try {
                Context context = acVar.getContext() != null ? acVar.getContext() : MMApplicationContext.getContext();
                Intent putExtra = new Intent(context, kGI.get(MMApplicationContext.getProcessName().replaceFirst(MMApplicationContext.getPackageName(), ""))).putExtra("appId", acVar.getAppId());
                if (!(context instanceof Activity)) {
                    putExtra.addFlags(268435456);
                }
                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(putExtra);
                com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/appbrand/ad/AppBrandAdUtils", "openAdUIFromMenu", "(Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageView;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                context.startActivity((Intent) bl.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/appbrand/ad/AppBrandAdUtils", "openAdUIFromMenu", "(Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageView;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.AppBrandAdUtils[AppBrandSplashAd]", e2, "openAdUIFromMenu fail", new Object[0]);
                AppMethodBeat.o(44028);
                return;
            }
        }
        AppMethodBeat.o(44028);
    }

    public static boolean dE(Context context) {
        return context instanceof AppBrandAdUI;
    }

    public static void I(AppBrandRuntime appBrandRuntime) {
        AppMethodBeat.i(44030);
        if (appBrandRuntime == null) {
            AppMethodBeat.o(44030);
            return;
        }
        if (appBrandRuntime.brM()) {
            com.tencent.mm.plugin.appbrand.ad.a.e eVar = new com.tencent.mm.plugin.appbrand.ad.a.e();
            eVar.source = "launch";
            eVar.d(appBrandRuntime.NY());
        }
        AppMethodBeat.o(44030);
    }

    public static void J(AppBrandRuntime appBrandRuntime) {
        AppMethodBeat.i(44031);
        if (appBrandRuntime == null) {
            AppMethodBeat.o(44031);
            return;
        }
        if (appBrandRuntime.brM()) {
            d dVar = new d();
            dVar.source = "launch";
            dVar.d(appBrandRuntime.NY());
        }
        AppMethodBeat.o(44031);
    }

    public static boolean d(ac acVar) {
        AppMethodBeat.i(44032);
        if (!p.Um(acVar.getAppId()).kCO.kGr || Util.isNullOrNil(Uy(acVar.getAppId()))) {
            AppMethodBeat.o(44032);
            return false;
        }
        AppMethodBeat.o(44032);
        return true;
    }

    public static void af(String str, boolean z) {
        AppMethodBeat.i(44034);
        p.Un(str).kCO.kGr = z;
        AppMethodBeat.o(44034);
    }

    public static String Uy(String str) {
        AppMethodBeat.i(44035);
        String str2 = p.Um(str).kCO.name;
        AppMethodBeat.o(44035);
        return str2;
    }

    public static void cm(String str, String str2) {
        AppMethodBeat.i(44036);
        p.Un(str).kCO.name = str2;
        AppMethodBeat.o(44036);
    }

    public static String Uz(String str) {
        AppMethodBeat.i(44037);
        String str2 = p.Um(str).kCO.icon;
        AppMethodBeat.o(44037);
        return str2;
    }

    public static void cn(String str, String str2) {
        AppMethodBeat.i(44038);
        p.Un(str).kCO.icon = str2;
        AppMethodBeat.o(44038);
    }

    public static void M(String str, long j2) {
        AppMethodBeat.i(226259);
        if (p.Um(str).kCO.kGE == 0) {
            p.Un(str).kCO.kGE = j2;
        }
        AppMethodBeat.o(226259);
    }

    public static void N(String str, long j2) {
        AppMethodBeat.i(226260);
        if (p.Um(str).kCO.kGF == 0) {
            p.Un(str).kCO.kGF = j2;
        }
        AppMethodBeat.o(226260);
    }
}

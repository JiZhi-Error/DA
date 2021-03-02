package com.tencent.mm.plugin.wepkg;

import android.content.SharedPreferences;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.wepkg.model.BaseWepkgProcessTask;
import com.tencent.mm.plugin.wepkg.model.a;
import com.tencent.mm.plugin.wepkg.model.h;
import com.tencent.mm.plugin.wepkg.model.i;
import com.tencent.mm.plugin.wepkg.version.WepkgVersionUpdater;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public final class d {
    private static int JLA = 0;
    private static Map<String, h> JLz = new HashMap();
    private static boolean enable = true;

    static {
        AppMethodBeat.i(110534);
        AppMethodBeat.o(110534);
    }

    public static void cCf() {
        AppMethodBeat.i(110522);
        gkp();
        a.cCf();
        AppMethodBeat.o(110522);
    }

    public static void gkp() {
        AppMethodBeat.i(110523);
        if (!AppBrandMainProcessService.isLive()) {
            com.tencent.mm.plugin.wepkg.utils.d.b("", new a() {
                /* class com.tencent.mm.plugin.wepkg.d.AnonymousClass1 */

                @Override // com.tencent.mm.plugin.wepkg.model.a
                public final void a(BaseWepkgProcessTask baseWepkgProcessTask) {
                }
            });
        }
        AppMethodBeat.o(110523);
    }

    private static boolean bcb(String str) {
        AppMethodBeat.i(110524);
        if (!AppBrandMainProcessService.isLive()) {
            com.tencent.mm.plugin.wepkg.utils.d.b("", new a() {
                /* class com.tencent.mm.plugin.wepkg.d.AnonymousClass2 */

                @Override // com.tencent.mm.plugin.wepkg.model.a
                public final void a(BaseWepkgProcessTask baseWepkgProcessTask) {
                }
            });
            com.tencent.mm.plugin.wepkg.utils.a.b("EnterWeb", str, com.tencent.mm.plugin.wepkg.utils.d.bcO(str), null, 0, 0, com.tencent.mm.plugin.wepkg.utils.a.ahr(10));
            AppMethodBeat.o(110524);
            return false;
        }
        AppMethodBeat.o(110524);
        return true;
    }

    public static void gkq() {
        AppMethodBeat.i(110525);
        if (JLA == 0) {
            a.vC();
        }
        JLA++;
        AppMethodBeat.o(110525);
    }

    public static int gkr() {
        return JLA;
    }

    public static void gks() {
        AppMethodBeat.i(110526);
        int i2 = JLA - 1;
        JLA = i2;
        if (i2 == 0) {
            JLz.clear();
            a.vC();
        }
        AppMethodBeat.o(110526);
    }

    public static void aer(String str) {
        AppMethodBeat.i(110527);
        JLz.remove(str);
        AppMethodBeat.o(110527);
    }

    public static h bcc(String str) {
        AppMethodBeat.i(200145);
        if (Util.isNullOrNil(str) || !JLz.containsKey(str)) {
            AppMethodBeat.o(200145);
            return null;
        }
        h hVar = JLz.get(str);
        AppMethodBeat.o(200145);
        return hVar;
    }

    public static h cU(String str, boolean z) {
        AppMethodBeat.i(110529);
        Log.d("MicroMsg.WePkgLoader", "load, url: %s", str);
        if (!bcb(str)) {
            Log.e("MicroMsg.WePkgLoader", "wepkg service is dead, start");
            com.tencent.mm.plugin.report.service.h.INSTANCE.dN(859, 36);
            h hVar = new h(10, false, "");
            AppMethodBeat.o(110529);
            return hVar;
        }
        int gkt = gkt();
        if (gkt != 0) {
            Log.e("MicroMsg.WePkgLoader", "load enable false");
            h hVar2 = new h(gkt, false, "");
            AppMethodBeat.o(110529);
            return hVar2;
        }
        final String bcO = com.tencent.mm.plugin.wepkg.utils.d.bcO(str);
        if (z) {
            Log.d("MicroMsg.WePkgLoader", "updateWePkg Bgn: %d", Long.valueOf(System.currentTimeMillis()));
            com.tencent.mm.plugin.wepkg.utils.d.cyh().postToWorker(new Runnable() {
                /* class com.tencent.mm.plugin.wepkg.d.AnonymousClass3 */

                public final void run() {
                    AppMethodBeat.i(110521);
                    String str = bcO;
                    HashSet hashSet = new HashSet();
                    if (!Util.isNullOrNil(str)) {
                        hashSet.add(str);
                    }
                    if (!Util.isNullOrNil(a.gkm())) {
                        hashSet.add(a.gkm());
                    }
                    WepkgVersionUpdater.a(hashSet, 0, false);
                    AppMethodBeat.o(110521);
                }
            });
        }
        if (Util.isNullOrNil(bcO)) {
            h hVar3 = new h(9, false, "");
            AppMethodBeat.o(110529);
            return hVar3;
        }
        h bcd = bcd(str);
        AppMethodBeat.o(110529);
        return bcd;
    }

    public static h bcd(String str) {
        h bcF;
        AppMethodBeat.i(110530);
        String bcO = com.tencent.mm.plugin.wepkg.utils.d.bcO(str);
        if (JLz.containsKey(bcO)) {
            bcF = JLz.get(bcO);
            String bcP = com.tencent.mm.plugin.wepkg.utils.d.bcP(str);
            if (!(bcF == null || bcF.JNh == null || !bcP.equalsIgnoreCase(bcF.JNh.domain))) {
                Log.i("MicroMsg.WePkgLoader", "memory has pkgid:%s record, version:%s", bcF.JNh.hhD, bcF.JNh.version);
                AppMethodBeat.o(110530);
                return bcF;
            }
        }
        bcF = i.bcF(str);
        if (bcF.dTL()) {
            JLz.put(bcO, bcF);
        }
        AppMethodBeat.o(110530);
        return bcF;
    }

    public static int gkt() {
        AppMethodBeat.i(184498);
        if (!enable) {
            AppMethodBeat.o(184498);
            return 12;
        } else if (com.tencent.mm.plugin.game.commlib.a.dSV()) {
            Log.i("MicroMsg.WePkgLoader", "config wepkg disable");
            enable = false;
            AppMethodBeat.o(184498);
            return 12;
        } else {
            SharedPreferences sharedPreferences = MMApplicationContext.getContext().getSharedPreferences("we_pkg_sp", 4);
            if (sharedPreferences == null || !sharedPreferences.getBoolean("disable_we_pkg", false)) {
                AppMethodBeat.o(184498);
                return 0;
            }
            Log.i("MicroMsg.WePkgLoader", "white screen, disable wepkg");
            enable = false;
            AppMethodBeat.o(184498);
            return 11;
        }
    }

    public static String bce(String str) {
        AppMethodBeat.i(110532);
        try {
            String queryParameter = Uri.parse(str).getQueryParameter("wepkg_rid");
            AppMethodBeat.o(110532);
            return queryParameter;
        } catch (Exception e2) {
            Log.i("MicroMsg.WePkgLoader", "getWePkgRid, url: %s, exception: ", str, e2.getMessage());
            AppMethodBeat.o(110532);
            return null;
        }
    }

    public static String bcf(String str) {
        AppMethodBeat.i(110533);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(110533);
            return "";
        } else if (str.equals(Util.nullAsNil(a.gkm()))) {
            String gkn = a.gkn();
            AppMethodBeat.o(110533);
            return gkn;
        } else if (str.equals("jscore_lib")) {
            String gkn2 = b.gkn();
            AppMethodBeat.o(110533);
            return gkn2;
        } else {
            h hVar = JLz.get(str);
            if (hVar == null || hVar.JNh == null) {
                AppMethodBeat.o(110533);
                return "";
            }
            String str2 = hVar.JNh.version;
            AppMethodBeat.o(110533);
            return str2;
        }
    }

    public static void gku() {
        enable = false;
    }
}

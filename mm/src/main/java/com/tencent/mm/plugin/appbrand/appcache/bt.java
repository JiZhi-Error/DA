package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.api.e;
import com.tencent.mm.plugin.appbrand.appcache.a.b;
import com.tencent.mm.plugin.appbrand.appcache.ae;
import com.tencent.mm.plugin.appbrand.appcache.bj;
import com.tencent.mm.pluginsdk.j.a.c.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.s;

public final class bt {
    static {
        AppMethodBeat.i(90671);
        bt.class.getClassLoader();
        j.Ed("wechatzstd");
        AppMethodBeat.o(90671);
    }

    public static boolean a(String str, String str2, int i2, int i3, bj.a aVar) {
        AppMethodBeat.i(90667);
        boolean a2 = bj.a(new bs(str, str2, i2, i3, aVar), aVar);
        AppMethodBeat.o(90667);
        return a2;
    }

    public static void a(bs bsVar, ae.a aVar) {
        AppMethodBeat.i(90668);
        bh bub = ((e) g.af(e.class)).bub();
        if (bub == null) {
            bj.a(bsVar.JYs, bsVar.appId, b.a.EnumC0543a.ENV_ERR, (bj.b) null);
            AppMethodBeat.o(90668);
            return;
        }
        aVar.bvp();
        boolean a2 = a(bsVar);
        aVar.gF(a2);
        Log.i("MicroMsg.AppBrand.ZstdLogic", "processZstd, appId:%s, success:%b", bsVar.appId, Boolean.valueOf(a2));
        if (a2) {
            bj.a(bsVar.JYs, bsVar.appId, bsVar.bwC(), bsVar.pkgVersion, bsVar.dMe, aVar);
            AppMethodBeat.o(90668);
            return;
        }
        s.deleteFile(bsVar.bwC());
        bd a3 = bub.a(bsVar.appId, bsVar.pkgVersion, bsVar.dMe, "downloadURL");
        if (a3 == null) {
            bj.a(bsVar.JYs, bsVar.appId, b.a.EnumC0543a.ENV_ERR, (bj.b) null);
            AppMethodBeat.o(90668);
            return;
        }
        bj.Vu(bsVar.JYs);
        bj.c(bsVar.appId, bsVar.dMe, bsVar.pkgVersion, a3.field_downloadURL, bsVar.kMv);
        AppMethodBeat.o(90668);
    }

    public static void a(bs bsVar, m mVar, ae.a aVar) {
        AppMethodBeat.i(90669);
        Log.e("MicroMsg.AppBrand.ZstdLogic", "onZstdPkgDownloadFail, request(%s %d)", bsVar.appId, Integer.valueOf(bsVar.pkgVersion));
        aVar.a(mVar);
        bh bub = ((e) g.af(e.class)).bub();
        if (bub == null) {
            Log.e("MicroMsg.AppBrand.ZstdLogic", "onZstdPkgDownloadFail, before fallback full_pkg, nil storage");
            bj.a(bsVar.JYs, bsVar.appId, b.a.EnumC0543a.ENV_ERR, (bj.b) null);
            AppMethodBeat.o(90669);
            return;
        }
        bj.Vu(bsVar.JYs);
        if (bsVar.kMv instanceof b.c) {
            ((b.c) bsVar.kMv).bwE();
            bd a2 = bub.a(bsVar.appId, bsVar.pkgVersion, bsVar.dMe, "downloadURL");
            if (a2 == null) {
                Log.e("MicroMsg.AppBrand.ZstdLogic", "onZstdPkgDownloadFail, before fallback full_pkg, nil record(%s %d)", bsVar.appId, Integer.valueOf(bsVar.pkgVersion));
                AppMethodBeat.o(90669);
                return;
            }
            if (!bj.c(bsVar.appId, bsVar.dMe, bsVar.pkgVersion, a2.field_downloadURL, bsVar.kMv)) {
                bsVar.kMv.a(bsVar.appId, b.a.EnumC0543a.ENV_ERR, null);
            }
            AppMethodBeat.o(90669);
            return;
        }
        bsVar.kMv.a(bsVar.appId, b.a.EnumC0543a.FAILED, null);
        AppMethodBeat.o(90669);
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x007f A[SYNTHETIC, Splitter:B:23:0x007f] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0084 A[SYNTHETIC, Splitter:B:26:0x0084] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00a3 A[SYNTHETIC, Splitter:B:39:0x00a3] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00a8 A[SYNTHETIC, Splitter:B:42:0x00a8] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean a(com.tencent.mm.plugin.appbrand.appcache.bs r9) {
        /*
        // Method dump skipped, instructions count: 199
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.appcache.bt.a(com.tencent.mm.plugin.appbrand.appcache.bs):boolean");
    }
}

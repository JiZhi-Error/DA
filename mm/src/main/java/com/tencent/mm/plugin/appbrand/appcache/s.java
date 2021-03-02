package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.api.e;
import com.tencent.mm.plugin.appbrand.appcache.a.b;
import com.tencent.mm.plugin.appbrand.appcache.ae;
import com.tencent.mm.plugin.appbrand.appcache.bj;
import com.tencent.mm.pluginsdk.j.a.c.m;
import com.tencent.mm.sdk.platformtools.Log;

public final class s {
    public static boolean a(String str, int i2, int i3, String str2, bj.a aVar) {
        AppMethodBeat.i(90552);
        boolean a2 = bj.a(new aw(str, i2, i3, str2, aVar), aVar);
        AppMethodBeat.o(90552);
        return a2;
    }

    static void a(aw awVar, m mVar, ae.a aVar) {
        AppMethodBeat.i(90553);
        Log.e("MicroMsg.AppBrand.IncrementalPkgLogic[incremental]", "onIncrementalPkgDownloadFail, request(%s %d->%d)", awVar.appId, Integer.valueOf(awVar.kMt), Integer.valueOf(awVar.kMu));
        aVar.a(mVar);
        bh bub = ((e) g.af(e.class)).bub();
        if (bub == null) {
            Log.e("MicroMsg.AppBrand.IncrementalPkgLogic[incremental]", "onIncrementalPkgDownloadFail, before fallback full_pkg, nil storage");
            bj.a(awVar.JYs, awVar.appId, b.a.EnumC0543a.ENV_ERR, (bj.b) null);
            AppMethodBeat.o(90553);
            return;
        }
        bj.Vu(awVar.JYs);
        bd a2 = bub.a(awVar.appId, awVar.kMu, 0, "downloadURL");
        if (a2 == null) {
            Log.e("MicroMsg.AppBrand.IncrementalPkgLogic[incremental]", "onIncrementalPkgDownloadFail, before fallback full_pkg, nil record(%s %d)", awVar.appId, Integer.valueOf(awVar.kMu));
            AppMethodBeat.o(90553);
            return;
        }
        if (awVar.kMv instanceof b.AbstractC0544b) {
            ((b.AbstractC0544b) awVar.kMv).bwD();
        }
        bj.c(awVar.appId, 0, awVar.kMu, a2.field_downloadURL, awVar.kMv);
        AppMethodBeat.o(90553);
    }

    static int B(String str, String str2, String str3) {
        int i2 = 1;
        AppMethodBeat.i(90554);
        try {
            i2 = WABSPatch.bspatch(str, str2, str3);
            AppMethodBeat.o(90554);
        } catch (Exception e2) {
            Log.e("MicroMsg.AppBrand.IncrementalPkgLogic[incremental]", "mergeDiffPkg e = %s, old[%s], new[%s], diff[%s]", e2, str, str2, str3);
            AppMethodBeat.o(90554);
        }
        return i2;
    }
}

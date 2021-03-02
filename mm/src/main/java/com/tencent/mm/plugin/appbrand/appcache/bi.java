package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.plugin.appbrand.app.n;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgStorageInvalidRecordFixer;", "", "()V", "TAG", "", "removeInvalidReleaseRecords", "", "plugin-appbrand-integration_release"})
public final class bi {
    public static final bi kNS = new bi();

    static {
        AppMethodBeat.i(50182);
        AppMethodBeat.o(50182);
    }

    private bi() {
    }

    public static final void bwz() {
        AppMethodBeat.i(50181);
        r.a buy = n.buy();
        if (buy != null) {
            try {
                Boolean.valueOf(buy.execSQL("AppBrandWxaPkgManifestRecord", "delete from AppBrandWxaPkgManifestRecord where debugType=0 and version=0"));
                AppMethodBeat.o(50181);
            } catch (Exception e2) {
                Log.printErrStackTrace("MiroMsg.WxaPkgStorageInvalidRecordFixer", e2, " removeInvalidReleaseRecords", new Object[0]);
                x xVar = x.SXb;
                AppMethodBeat.o(50181);
            }
        } else {
            AppMethodBeat.o(50181);
        }
    }
}

package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;

public final class bo {
    private static a kOz = null;

    public interface a {
        q a(AppBrandRuntime appBrandRuntime, bg bgVar);
    }

    static q a(AppBrandRuntime appBrandRuntime, bg bgVar) {
        q a2;
        AppMethodBeat.i(178571);
        if (kOz == null || (a2 = kOz.a(appBrandRuntime, bgVar)) == null) {
            z zVar = new z(appBrandRuntime.mAppId, appBrandRuntime.OT().leE);
            AppMethodBeat.o(178571);
            return zVar;
        }
        AppMethodBeat.o(178571);
        return a2;
    }

    public static void a(a aVar) {
        kOz = aVar;
    }
}

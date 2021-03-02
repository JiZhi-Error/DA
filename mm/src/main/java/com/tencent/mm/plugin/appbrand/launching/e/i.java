package com.tencent.mm.plugin.appbrand.launching.e;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.WxaCommLibRuntimeReader;
import com.tencent.mm.plugin.appbrand.appcache.at;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.h;
import com.tencent.mm.plugin.appbrand.launching.c;
import com.tencent.mm.plugin.appbrand.launching.j;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.sdk.platformtools.Log;

public final class i {
    public static ICommLibReader bOk() {
        AppMethodBeat.i(227140);
        if (at.bvT() == null) {
            WxaCommLibRuntimeReader.bvY();
        }
        ICommLibReader bvT = at.bvT();
        AppMethodBeat.o(227140);
        return bvT;
    }

    static void b(Context context, AppBrandInitConfigWC appBrandInitConfigWC, AppBrandStatObject appBrandStatObject) {
        AppMethodBeat.i(47464);
        Log.i("MicroMsg.AppBrand.PreconditionUtil", "startAppOnInitConfigGot, %s", appBrandInitConfigWC);
        c.b(appBrandInitConfigWC, appBrandStatObject);
        j.a(context, appBrandInitConfigWC, appBrandStatObject);
        h.bzT().a(appBrandInitConfigWC.username, appBrandInitConfigWC);
        AppMethodBeat.o(47464);
    }
}

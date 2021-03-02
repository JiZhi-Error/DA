package com.tencent.mm.plugin.appbrand;

import android.graphics.Bitmap;
import com.tencent.luggage.game.d.a.a.b;
import com.tencent.luggage.game.d.a.a.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.ca;
import com.tencent.mm.plugin.appbrand.page.t;
import com.tencent.mm.plugin.appbrand.service.c;
import com.tencent.mm.sdk.platformtools.Log;

public final class ay {
    public static Bitmap F(AppBrandRuntime appBrandRuntime) {
        AppMethodBeat.i(226251);
        if (AppBrandRuntimeWCAccessible.isGame(appBrandRuntime)) {
            b bVar = (b) ((c) appBrandRuntime.NY()).S(b.class);
            if (bVar != null) {
                Bitmap a2 = com.tencent.magicbrush.b.a(bVar.getMagicBrush().cLA);
                AppMethodBeat.o(226251);
                return a2;
            }
            Log.printErrStackTrace("MicroMsg.AppBrand.RuntimeRestartHelper", new d(), "hy: not game service", new Object[0]);
            AppMethodBeat.o(226251);
            return null;
        }
        t currentPage = appBrandRuntime.brh().getCurrentPage();
        if (currentPage == null) {
            AppMethodBeat.o(226251);
            return null;
        }
        Bitmap cD = ca.cD(currentPage);
        AppMethodBeat.o(226251);
        return cD;
    }
}

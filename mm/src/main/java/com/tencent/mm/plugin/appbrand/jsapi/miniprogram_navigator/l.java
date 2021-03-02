package com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.launching.e.f;
import com.tencent.mm.plugin.appbrand.q;
import kotlin.g.b.p;

@kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÁ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tH\u0007¨\u0006\n"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/miniprogram_navigator/MiniProgramNavigatorUglyLogic;", "", "()V", "loadNewRuntimeUglyMaybe", "", "from", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;", "to", "config", "Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;", "plugin-appbrand-integration_release"})
public final class l {
    public static final l mfk = new l();

    static {
        AppMethodBeat.i(50584);
        AppMethodBeat.o(50584);
    }

    private l() {
    }

    public static final boolean a(q qVar, q qVar2, AppBrandInitConfigWC appBrandInitConfigWC) {
        AppMethodBeat.i(50583);
        p.h(qVar, "from");
        p.h(qVar2, "to");
        p.h(appBrandInitConfigWC, "config");
        if (!qVar.NA() || !appBrandInitConfigWC.NA()) {
            AppMethodBeat.o(50583);
            return false;
        }
        f.mZp.a(qVar.getContext(), null, appBrandInitConfigWC.appId, appBrandInitConfigWC.kHw, appBrandInitConfigWC.eix, appBrandInitConfigWC.appVersion, appBrandInitConfigWC.Nz(), appBrandInitConfigWC.cys, null);
        AppMethodBeat.o(50583);
        return true;
    }
}

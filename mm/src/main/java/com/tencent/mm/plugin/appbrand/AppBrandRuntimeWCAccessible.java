package com.tencent.mm.plugin.appbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.k;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u000e\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u0004\u0018\u00010\u0002\u001a\f\u0010\u0003\u001a\u00020\u0004*\u0004\u0018\u00010\u0005\u001a\f\u0010\u0003\u001a\u00020\u0004*\u0004\u0018\u00010\u0006\u001a\f\u0010\u0003\u001a\u00020\u0004*\u0004\u0018\u00010\u0002\u001a\f\u0010\u0007\u001a\u00020\u0004*\u0004\u0018\u00010\u0005\u001a\f\u0010\b\u001a\u00020\u0004*\u0004\u0018\u00010\u0005¨\u0006\t"}, hxF = {"getUsername", "", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "isGame", "", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfig;", "isPluginApp", "isWeishiApp", "plugin-appbrand-integration_release"})
public final class AppBrandRuntimeWCAccessible {
    public static final String c(f fVar) {
        AppBrandInitConfigWC bsC;
        AppMethodBeat.i(50147);
        k kVar = (k) (!(fVar instanceof k) ? null : fVar);
        AppBrandRuntime runtime = kVar != null ? kVar.getRuntime() : null;
        if (!(runtime instanceof q)) {
            runtime = null;
        }
        q qVar = (q) runtime;
        if (qVar == null || (bsC = qVar.bsC()) == null) {
            AppMethodBeat.o(50147);
            return null;
        }
        String str = bsC.username;
        AppMethodBeat.o(50147);
        return str;
    }

    public static final boolean isGame(AppBrandRuntime appBrandRuntime) {
        AppMethodBeat.i(50148);
        q qVar = (q) (!(appBrandRuntime instanceof q) ? null : appBrandRuntime);
        if (qVar != null) {
            boolean NA = qVar.NA();
            AppMethodBeat.o(50148);
            return NA;
        }
        AppMethodBeat.o(50148);
        return false;
    }

    public static final boolean g(AppBrandInitConfig appBrandInitConfig) {
        AppMethodBeat.i(50149);
        AppBrandInitConfigWC appBrandInitConfigWC = (AppBrandInitConfigWC) (!(appBrandInitConfig instanceof AppBrandInitConfigWC) ? null : appBrandInitConfig);
        if (appBrandInitConfigWC != null) {
            boolean NA = appBrandInitConfigWC.NA();
            AppMethodBeat.o(50149);
            return NA;
        }
        AppMethodBeat.o(50149);
        return false;
    }

    public static final boolean D(AppBrandRuntime appBrandRuntime) {
        AppMethodBeat.i(50150);
        q qVar = (q) (!(appBrandRuntime instanceof q) ? null : appBrandRuntime);
        if (qVar != null) {
            boolean bsr = qVar.bsr();
            AppMethodBeat.o(50150);
            return bsr;
        }
        AppMethodBeat.o(50150);
        return false;
    }

    public static final boolean d(f fVar) {
        AppBrandRuntime runtime;
        AppMethodBeat.i(50151);
        k kVar = (k) (!(fVar instanceof k) ? null : fVar);
        if (kVar == null || (runtime = kVar.getRuntime()) == null) {
            AppMethodBeat.o(50151);
            return false;
        }
        boolean isGame = isGame(runtime);
        AppMethodBeat.o(50151);
        return isGame;
    }

    public static final boolean E(AppBrandRuntime appBrandRuntime) {
        AppMethodBeat.i(227895);
        boolean j2 = p.j(appBrandRuntime != null ? appBrandRuntime.getAppId() : null, "wxfe02ecfe70800f46");
        AppMethodBeat.o(227895);
        return j2;
    }
}

package com.tencent.mm.plugin.appbrand.task;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ui.AppBrandUI;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;

@kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\n"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/task/AppBrandUILifeCycleSpeedProfile;", "", "()V", "TAG", "", "onAppBrandUILifeCycle", "", "ui", "Lcom/tencent/mm/plugin/appbrand/ui/AppBrandUI;", "lifecycle", "plugin-appbrand-integration_release"})
public final class l {
    public static final l nQh = new l();

    static {
        AppMethodBeat.i(51067);
        AppMethodBeat.o(51067);
    }

    private l() {
    }

    public static void b(AppBrandUI appBrandUI, String str) {
        AppMethodBeat.i(51066);
        p.h(appBrandUI, "ui");
        p.h(str, "lifecycle");
        try {
            Log.i("MicroMsg.AppBrandUILifeCycleSpeedProfile", "onAppBrandLifeCycle " + appBrandUI.hashCode() + ' ' + appBrandUI.getLocalClassName() + ' ' + str);
            AppMethodBeat.o(51066);
        } catch (Throwable th) {
            Log.i("MicroMsg.AppBrandUILifeCycleSpeedProfile", "onAppBrandLifeCycle " + appBrandUI.hashCode() + ' ' + appBrandUI.getClass().getSimpleName() + ' ' + str);
            AppMethodBeat.o(51066);
        }
    }
}

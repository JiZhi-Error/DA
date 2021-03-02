package com.tencent.luggage.sdk.customize.impl;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.ui.ah;

public final class a implements ah {
    @Override // com.tencent.mm.plugin.appbrand.ui.ah
    public final void a(AppBrandRuntime appBrandRuntime, Runnable runnable, AppBrandRuntime appBrandRuntime2) {
        AppMethodBeat.i(230538);
        runnable.run();
        AppMethodBeat.o(230538);
    }

    @Override // com.tencent.mm.plugin.appbrand.ui.ah
    public final void a(AppBrandRuntime appBrandRuntime, AppBrandRuntime appBrandRuntime2, Runnable runnable) {
        AppMethodBeat.i(139819);
        if (runnable != null) {
            runnable.run();
        }
        AppMethodBeat.o(139819);
    }

    @Override // com.tencent.mm.plugin.appbrand.ui.ah
    public final void a(Activity activity, AppBrandInitConfig appBrandInitConfig) {
    }

    @Override // com.tencent.mm.plugin.appbrand.ui.ah
    public final void m(Activity activity) {
    }
}

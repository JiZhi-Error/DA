package com.tencent.luggage.sdk.d;

import android.annotation.SuppressLint;
import android.app.Activity;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.n;
import com.tencent.mm.plugin.appbrand.platform.window.c.a.a;
import com.tencent.mm.plugin.appbrand.platform.window.c.a.b;
import com.tencent.mm.plugin.appbrand.platform.window.e;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.ui.ah;
import com.tencent.mm.sdk.platformtools.Log;

@SuppressLint({"ViewConstructor"})
public final class c extends n<d> implements b {
    private e cCk;

    @Override // com.tencent.mm.plugin.appbrand.n, com.tencent.mm.plugin.appbrand.platform.window.c, com.tencent.mm.plugin.appbrand.platform.window.g
    public final e getOrientationHandler() {
        AppMethodBeat.i(229871);
        if (this.cCk == null) {
            this.cCk = new a(this);
        }
        e eVar = this.cCk;
        AppMethodBeat.o(229871);
        return eVar;
    }

    @Override // com.tencent.mm.plugin.appbrand.n
    public final void b(AppBrandRuntime appBrandRuntime, AppBrandRuntime appBrandRuntime2, Runnable runnable) {
        String str;
        AppMethodBeat.i(229872);
        super.b(appBrandRuntime, appBrandRuntime2, runnable);
        Object[] objArr = new Object[2];
        if (appBrandRuntime == null) {
            str = BuildConfig.COMMAND;
        } else {
            str = appBrandRuntime.mAppId;
        }
        objArr[0] = str;
        objArr[1] = appBrandRuntime2.mAppId;
        Log.i("Luggage.FULL.AppBrandRuntimeContainerViewImplLu", "onRuntimeClose entered, in.appId[%s], out.appId[%s]", objArr);
        runnable.run();
        if (getStackSize() > 1 || appBrandRuntime != null) {
            if (appBrandRuntime2.brG()) {
                ((ah) com.tencent.luggage.a.e.M(ah.class)).a(appBrandRuntime, appBrandRuntime2, (Runnable) null);
            }
            AppMethodBeat.o(229872);
            return;
        }
        Activity activity = getActivity();
        if (activity == null) {
            Log.i("Luggage.FULL.AppBrandRuntimeContainerViewImplLu", "closeActivity: fail");
        } else if (!activity.isFinishing()) {
            activity.moveTaskToBack(true);
            if (getStackSize() <= 0) {
                activity.overridePendingTransition(0, 0);
            } else {
                ((ah) com.tencent.luggage.a.e.M(ah.class)).m(activity);
            }
        }
        Log.i("Luggage.FULL.AppBrandRuntimeContainerViewImplLu", "onRuntimeClose: activity closed");
        AppMethodBeat.o(229872);
    }

    @Override // com.tencent.mm.plugin.appbrand.n, com.tencent.mm.plugin.appbrand.platform.window.g
    public final boolean OG() {
        return false;
    }

    public final void a(d dVar, AppBrandInitConfigLU appBrandInitConfigLU, AppBrandStatObject appBrandStatObject) {
        AppMethodBeat.i(229873);
        appBrandInitConfigLU.cyA = appBrandStatObject;
        super.a((AppBrandRuntime) dVar, (AppBrandInitConfig) appBrandInitConfigLU);
        AppMethodBeat.o(229873);
    }
}

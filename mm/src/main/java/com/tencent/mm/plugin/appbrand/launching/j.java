package com.tencent.mm.plugin.appbrand.launching;

import android.app.Activity;
import android.content.Context;
import android.util.AndroidRuntimeException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.g;
import com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.m;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.task.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;

public final class j {
    public static void a(final Context context, final AppBrandInitConfigWC appBrandInitConfigWC, final AppBrandStatObject appBrandStatObject) {
        AppMethodBeat.i(47119);
        AnonymousClass1 r0 = new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.launching.j.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(47118);
                Context context = context;
                AppBrandInitConfigWC appBrandInitConfigWC = appBrandInitConfigWC;
                AppBrandStatObject appBrandStatObject = appBrandStatObject;
                appBrandInitConfigWC.ldO = Util.nowMilliSecond();
                if (g.c(context, appBrandInitConfigWC, appBrandStatObject)) {
                    if (context instanceof Activity) {
                        appBrandInitConfigWC.cyA = appBrandStatObject;
                        m.a((Activity) context, appBrandInitConfigWC, appBrandStatObject);
                    }
                    Log.i("MicroMsg.AppBrand.AppLaunchLogic", "startAppImpl [applaunch] start functional runtime, config[%s]", appBrandInitConfigWC);
                    AppMethodBeat.o(47118);
                    return;
                }
                try {
                    int d2 = h.bWb().d(context, appBrandInitConfigWC, appBrandStatObject);
                    if (context instanceof Activity) {
                        appBrandInitConfigWC.cyA = appBrandStatObject;
                    }
                    Log.i("MicroMsg.AppBrand.AppLaunchLogic", "[applaunch] startAppOnInitConfigGot %s", appBrandInitConfigWC);
                    if (d2 == 1) {
                        Log.i("MicroMsg.AppBrand.AppLaunchLogic", "[applaunch] init AppLaunchPrepareProcess boost instance");
                        new k(appBrandInitConfigWC, appBrandStatObject).bNl();
                        o.a(21, appBrandInitConfigWC.appId, appBrandInitConfigWC.appVersion, appBrandInitConfigWC.eix, appBrandInitConfigWC.NA());
                    }
                    AppMethodBeat.o(47118);
                } catch (AndroidRuntimeException e2) {
                    Log.e("MicroMsg.AppBrand.AppLaunchLogic", "startAppImpl re = %s", e2);
                    AppMethodBeat.o(47118);
                }
            }
        };
        if (MMHandlerThread.isMainThread()) {
            r0.run();
            AppMethodBeat.o(47119);
            return;
        }
        MMHandlerThread.postToMainThread(r0);
        AppMethodBeat.o(47119);
    }
}

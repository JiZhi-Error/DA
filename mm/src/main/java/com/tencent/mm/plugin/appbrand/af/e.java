package com.tencent.mm.plugin.appbrand.af;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;

public final class e {
    public static boolean b(Activity activity, AppBrandInitConfig appBrandInitConfig) {
        AppMethodBeat.i(49344);
        if ("wxfe02ecfe70800f46".equalsIgnoreCase(appBrandInitConfig.appId)) {
            activity.overridePendingTransition(0, 0);
            AppMethodBeat.o(49344);
            return true;
        }
        AppMethodBeat.o(49344);
        return false;
    }
}

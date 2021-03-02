package com.tencent.mm.plugin.expt.hellhound.a.f.b;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public final class f {
    public static boolean af(Activity activity) {
        AppMethodBeat.i(177389);
        if (activity == null) {
            AppMethodBeat.o(177389);
            return false;
        }
        try {
            Field declaredField = Class.forName("com.tencent.mm.plugin.appbrand.ui.AppBrandUI").getDeclaredField("mRuntimeContainer");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(activity);
            Log.d("HABBYGE-MALI.LazySessionId", "mRuntimeContainer: %s", obj.getClass().getCanonicalName());
            Method declaredMethod = Class.forName("com.tencent.mm.plugin.appbrand.AppBrandRuntimeContainer").getDeclaredMethod("getActiveRuntime", new Class[0]);
            declaredMethod.setAccessible(true);
            Object invoke = declaredMethod.invoke(obj, new Object[0]);
            Log.d("HABBYGE-MALI.LazySessionId", "appBrandRuntime: %s", invoke.getClass().getCanonicalName());
            Method declaredMethod2 = Class.forName("com.tencent.mm.plugin.appbrand.AppBrandRuntimeWCAccessible").getDeclaredMethod("isGame", Class.forName("com.tencent.mm.plugin.appbrand.AppBrandRuntime"));
            declaredMethod2.setAccessible(true);
            boolean booleanValue = ((Boolean) declaredMethod2.invoke(null, invoke)).booleanValue();
            AppMethodBeat.o(177389);
            return booleanValue;
        } catch (Exception e2) {
            Log.printErrStackTrace("HABBYGE-MALI.LazySessionId", e2, "isAppBrandGame, crash: %s", e2.getMessage());
            AppMethodBeat.o(177389);
            return false;
        }
    }
}

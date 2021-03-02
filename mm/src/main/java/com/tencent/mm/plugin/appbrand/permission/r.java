package com.tencent.mm.plugin.appbrand.permission;

import android.support.v4.app.a;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ac.h;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Set;

public final class r {
    private static final h<String, a.AbstractC0015a> nxM = new h<>();

    static {
        AppMethodBeat.i(140777);
        AppMethodBeat.o(140777);
    }

    public static void a(String str, a.AbstractC0015a aVar) {
        AppMethodBeat.i(140773);
        if (TextUtils.isEmpty(str) || aVar == null) {
            Log.e("Luggage.RequestPermissionRegistry", "addCallback fail, invalid arguments");
            AppMethodBeat.o(140773);
            return;
        }
        nxM.r(str, aVar);
        AppMethodBeat.o(140773);
    }

    @Deprecated
    public static void b(String str, a.AbstractC0015a aVar) {
        AppMethodBeat.i(140774);
        a(str, aVar);
        AppMethodBeat.o(140774);
    }

    public static void aeq(String str) {
        AppMethodBeat.i(140775);
        if (TextUtils.isEmpty(str)) {
            Log.e("Luggage.RequestPermissionRegistry", "removeCallbacks fail, invalid arguments");
            AppMethodBeat.o(140775);
            return;
        }
        nxM.cN(str);
        AppMethodBeat.o(140775);
    }

    public static void a(String str, int i2, String[] strArr, int[] iArr) {
        AppMethodBeat.i(140776);
        if (str == null || str.length() == 0) {
            Log.e("Luggage.RequestPermissionRegistry", "removeCallback fail, invalid id");
            AppMethodBeat.o(140776);
            return;
        }
        Set<a.AbstractC0015a> cM = nxM.cM(str);
        if (cM != null) {
            for (a.AbstractC0015a aVar : cM) {
                aVar.onRequestPermissionsResult(i2, strArr, iArr);
            }
        }
        AppMethodBeat.o(140776);
    }
}

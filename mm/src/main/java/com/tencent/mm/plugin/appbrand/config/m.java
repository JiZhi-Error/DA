package com.tencent.mm.plugin.appbrand.config;

import com.tencent.luggage.a.e;
import com.tencent.luggage.sdk.d.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.performance.a;
import com.tencent.mm.plugin.appbrand.permission.i;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;

public final class m {
    private static final MultiProcessMMKV cQe = MultiProcessMMKV.getMMKV("com.tencent.mm.plugin.appbrand.config.AppDebugInfoHelper");

    static {
        AppMethodBeat.i(146993);
        AppMethodBeat.o(146993);
    }

    public static void an(String str, boolean z) {
        AppMethodBeat.i(146989);
        cQe.putBoolean(str + "_AppDebugEnabled", z).commit();
        AppMethodBeat.o(146989);
    }

    public static boolean Xc(String str) {
        AppMethodBeat.i(146990);
        boolean z = cQe.getBoolean(str + "_AppDebugEnabled", false);
        AppMethodBeat.o(146990);
        return z;
    }

    public static boolean Xd(String str) {
        AppMethodBeat.i(229881);
        boolean contains = cQe.contains(str + "_AppDebugEnabled");
        AppMethodBeat.o(229881);
        return contains;
    }

    public static void WY(String str) {
        AppMethodBeat.i(146991);
        cQe.remove(str + "_AppDebugEnabled").commit();
        AppMethodBeat.o(146991);
    }

    public static void Xe(String str) {
        AppMethodBeat.i(229882);
        cQe.putString("V8DebugFlags", str);
        AppMethodBeat.o(229882);
    }

    public static String bAc() {
        AppMethodBeat.i(229883);
        String string = cQe.getString("V8DebugFlags", "");
        AppMethodBeat.o(229883);
        return string;
    }

    public static void bAd() {
        AppMethodBeat.i(229884);
        cQe.remove("V8DebugFlags");
        AppMethodBeat.o(229884);
    }

    public static boolean c(d dVar) {
        AppMethodBeat.i(146992);
        a aVar = (a) dVar.d(a.class, false);
        if (aVar == null) {
            AppMethodBeat.o(146992);
            return false;
        } else if (dVar.OQ()) {
            AppMethodBeat.o(146992);
            return false;
        } else {
            boolean z = aVar.nwz;
            AppMethodBeat.o(146992);
            return z;
        }
    }

    public static boolean Xf(String str) {
        AppMethodBeat.i(229885);
        boolean aeo = ((i) e.M(i.class)).aeo(str);
        AppMethodBeat.o(229885);
        return aeo;
    }
}

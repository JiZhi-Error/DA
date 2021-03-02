package com.tencent.mm.plugin.appbrand.jsapi.nfc.hce.a;

import com.tencent.luggage.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.w.b;
import com.tencent.mm.sdk.platformtools.Log;

public final class c {
    public static void R(String str, int i2, int i3) {
        AppMethodBeat.i(136184);
        Log.i("MicroMsg.HCEReportManager", "alvinluo reportStartHCEResult appId: %s, result: %d, diff: %d", str, Integer.valueOf(i2), Integer.valueOf(i3));
        ((b) e.N(b.class)).a(14837, str, Integer.valueOf(i2), Integer.valueOf(i3));
        AppMethodBeat.o(136184);
    }
}

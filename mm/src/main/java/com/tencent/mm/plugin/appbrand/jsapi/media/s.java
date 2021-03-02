package com.tencent.mm.plugin.appbrand.jsapi.media;

import android.content.Intent;
import com.tencent.luggage.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.u.a;
import com.tencent.mm.plugin.appbrand.jsapi.u.c;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONObject;

final class s {
    public static void a(f fVar, JSONObject jSONObject, Intent intent, String str) {
        c cVar;
        AppMethodBeat.i(226907);
        a aVar = (a) e.M(a.class);
        if (aVar == null) {
            Log.w("MicroMsg.AppBrand.ReferrerHelper", "mayPutReferrer, referrerHelper is null");
            AppMethodBeat.o(226907);
            return;
        }
        c a2 = aVar.a(jSONObject, fVar);
        if (a2 == null) {
            cVar = aVar.bIw();
        } else {
            cVar = a2;
        }
        if (c.NO_REFERRER == cVar) {
            AppMethodBeat.o(226907);
            return;
        }
        intent.putExtra("IsFromWebViewReffer", str);
        AppMethodBeat.o(226907);
    }
}

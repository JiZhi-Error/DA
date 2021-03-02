package com.tencent.mm.ui.l.a.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.z.t;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.l.a.g;
import org.json.JSONObject;

public final class d extends t<g> {
    public static final int CTRL_INDEX = -2;
    public static final String NAME = "impact";

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.f, org.json.JSONObject, int] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.d, com.tencent.mm.plugin.appbrand.jsapi.z.t
    public final /* synthetic */ void a(g gVar, JSONObject jSONObject, int i2) {
        AppMethodBeat.i(234444);
        Log.i("MicroMsg.JsApiVibrateForMagicEmoji", "hy: request vibrate");
        super.a(gVar, jSONObject, i2);
        AppMethodBeat.o(234444);
    }
}

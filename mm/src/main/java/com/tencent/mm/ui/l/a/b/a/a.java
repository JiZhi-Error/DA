package com.tencent.mm.ui.l.a.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.l.a.e;
import com.tencent.mm.ui.l.a.g;
import org.json.JSONObject;

public final class a extends d<g> {
    public static final int CTRL_INDEX = -2;
    public static final String NAME = "finishLoading";

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.f, org.json.JSONObject, int] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final /* synthetic */ void a(g gVar, JSONObject jSONObject, int i2) {
        AppMethodBeat.i(234436);
        g gVar2 = gVar;
        Log.i("MicroMsg.JsApiFinishLoading", "hy: finish loading.");
        e eVar = gVar2.QlN;
        if (eVar == null) {
            Log.w("MicroMsg.JsApiFinishLoading", "hy: runtime released!!");
        } else {
            eVar.hYO();
        }
        gVar2.i(i2, h("ok", null));
        AppMethodBeat.o(234436);
    }
}

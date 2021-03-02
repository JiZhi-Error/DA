package com.tencent.mm.ui.l.a.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ab;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.l.a.g;
import org.json.JSONObject;

public final class b extends ab<g> {
    public static final int CTRL_INDEX = -2;
    public static final String NAME = "getMsgMeta";

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.f, org.json.JSONObject] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.ab
    public final /* synthetic */ String a(g gVar, JSONObject jSONObject) {
        AppMethodBeat.i(234437);
        long optLong = jSONObject.optLong("msgId", -1);
        boolean optBoolean = jSONObject.optBoolean("needFrame", true);
        long currentTicks = Util.currentTicks();
        e a2 = e.a(optLong, gVar, optBoolean);
        if (a2 != null) {
            if (BuildInfo.DEBUG) {
                Log.d("MicroMsg.JsApiGetMsgMeta", "hy: get msg meta %s, using %d ms", a2.toString(), Long.valueOf(Util.ticksToNow(currentTicks)));
            }
            String n = n("ok", a2.gWU());
            AppMethodBeat.o(234437);
            return n;
        }
        String h2 = h("ok", null);
        AppMethodBeat.o(234437);
        return h2;
    }
}

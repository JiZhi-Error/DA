package com.tencent.mm.plugin.appbrand.jsapi.audio;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.m.o;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import org.json.JSONObject;

public class f extends d {
    public static final int CTRL_INDEX = 291;
    public static final String NAME = "createAudioInstanceAsync";

    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final void a(com.tencent.mm.plugin.appbrand.jsapi.f fVar, JSONObject jSONObject, int i2) {
        AppMethodBeat.i(145705);
        a(fVar, jSONObject, i2, fVar.getJsRuntime());
        AppMethodBeat.o(145705);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final void a(final com.tencent.mm.plugin.appbrand.jsapi.f fVar, JSONObject jSONObject, final int i2, final o oVar) {
        AppMethodBeat.i(256423);
        Log.i("MicroMsg.JsApiCreateAudioInstanceAsync", "hy: create audio instance async invoke");
        new a() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.audio.f.AnonymousClass1 */

            @Override // com.tencent.mm.plugin.appbrand.jsapi.audio.d
            public final void YC() {
                AppMethodBeat.i(145704);
                Log.i("MicroMsg.JsApiCreateAudioInstanceAsync", "hy: start create audio instance async");
                String k = e.k(fVar);
                HashMap hashMap = new HashMap();
                hashMap.put("audioId", k);
                c.INSTANCE.Zm(fVar.getAppId()).a(k, oVar);
                fVar.i(i2, f.this.n("ok", hashMap));
                AppMethodBeat.o(145704);
            }
        }.bEy();
        AppMethodBeat.o(256423);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.p
    public final boolean bEi() {
        return true;
    }
}

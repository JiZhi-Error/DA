package com.tencent.mm.plugin.lite.jsapi.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.lite.jsapi.b;
import com.tencent.mm.plugin.topstory.a.h;
import com.tencent.mm.plugin.websearch.api.ai;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import org.json.JSONObject;

public class a extends b {
    @Override // com.tencent.mm.plugin.lite.jsapi.b
    public final int dTw() {
        return 1;
    }

    @Override // com.tencent.liteapp.jsapi.a
    public final void a(String str, JSONObject jSONObject) {
        AppMethodBeat.i(198847);
        Log.i("LiteAppJsApiDoGoToRecVideoList", "doGoToRecVideoList");
        try {
            ai.b(MMApplicationContext.getContext(), h.br(jSONObject));
            AppMethodBeat.o(198847);
        } catch (Exception e2) {
            Log.printErrStackTrace("LiteAppJsApiDoGoToRecVideoList", e2, "doGoToRecVideoList", new Object[0]);
            AppMethodBeat.o(198847);
        }
    }
}

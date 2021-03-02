package com.tencent.mm.plugin.lite.jsapi.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.lite.LiteAppCenter;
import com.tencent.mm.plugin.lite.jsapi.b;
import org.json.JSONObject;

public class g extends b {
    @Override // com.tencent.mm.plugin.lite.jsapi.b
    public final int dTw() {
        return 0;
    }

    @Override // com.tencent.liteapp.jsapi.a
    public final void a(String str, JSONObject jSONObject) {
        AppMethodBeat.i(198846);
        LiteAppCenter.onEventTriggered("testEvent", "{data: 'test data'}");
        AppMethodBeat.o(198846);
    }
}

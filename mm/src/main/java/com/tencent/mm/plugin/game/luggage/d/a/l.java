package com.tencent.mm.plugin.game.luggage.d.a;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.nr;
import com.tencent.mm.plugin.lite.jsapi.b;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONException;
import org.json.JSONObject;

public class l extends b {
    @Override // com.tencent.mm.plugin.lite.jsapi.b
    public final int dTw() {
        return 1;
    }

    @Override // com.tencent.liteapp.jsapi.a
    public final void a(String str, JSONObject jSONObject) {
        AppMethodBeat.i(186927);
        if (!jSONObject.has("url")) {
            AppMethodBeat.o(186927);
            return;
        }
        try {
            nr nrVar = new nr();
            nrVar.dTO.type = 2;
            Intent intent = new Intent();
            intent.putExtra("rawUrl", jSONObject.getString("url"));
            intent.putExtra("nextAnimIn", aU(jSONObject));
            intent.putExtra("currentAnimOut", aV(jSONObject));
            nrVar.dTO.intent = intent;
            EventCenter.instance.publish(nrVar);
            AppMethodBeat.o(186927);
        } catch (JSONException e2) {
            Log.printErrStackTrace("LiteAppJsApiStartGameWebview", e2, "get url", new Object[0]);
            AppMethodBeat.o(186927);
        }
    }
}

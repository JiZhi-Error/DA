package com.tencent.mm.plugin.game.luggage.b;

import android.content.Context;
import com.tencent.luggage.d.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ox;
import com.tencent.mm.plugin.game.luggage.g.i;
import com.tencent.mm.plugin.webview.luggage.jsapi.br;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.sqlitelint.behaviour.persistence.IssueStorage;
import org.json.JSONException;
import org.json.JSONObject;

public class v extends br<i> {
    @Override // com.tencent.luggage.d.b
    public final String name() {
        return "openGameCenter";
    }

    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final int dTs() {
        return 2;
    }

    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final void b(b<i>.a aVar) {
    }

    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final void a(Context context, String str, br.a aVar) {
        JSONObject jSONObject;
        AppMethodBeat.i(83079);
        try {
            JSONObject jSONObject2 = new JSONObject(str);
            int optInt = jSONObject2.optInt("jumpView");
            int optInt2 = jSONObject2.optInt("jumpType");
            Log.i("MicroMsg.JsApiOpenGameCenter", "jumpView = %d, jumpType = %d", Integer.valueOf(optInt), Integer.valueOf(optInt2));
            try {
                if (jSONObject2.has(IssueStorage.COLUMN_EXT_INFO)) {
                    jSONObject = new JSONObject(jSONObject2.optString(IssueStorage.COLUMN_EXT_INFO));
                } else {
                    jSONObject = new JSONObject();
                }
                try {
                    jSONObject.put("msgId", jSONObject2.optString("msgId"));
                    jSONObject.put("msgTabType", jSONObject2.optInt("msgTabType"));
                } catch (JSONException e2) {
                }
            } catch (JSONException e3) {
                jSONObject = null;
            }
            ox oxVar = new ox();
            oxVar.dUX.dUY = optInt;
            oxVar.dUX.jumpType = optInt2;
            if (jSONObject != null) {
                oxVar.dUX.extraInfo = jSONObject.toString();
            }
            oxVar.dUX.context = context;
            EventCenter.instance.publish(oxVar);
            aVar.i(null, null);
            AppMethodBeat.o(83079);
        } catch (JSONException e4) {
            Log.e("MicroMsg.JsApiOpenGameCenter", "json parse exception");
            aVar.i("fail", null);
            AppMethodBeat.o(83079);
        }
    }
}

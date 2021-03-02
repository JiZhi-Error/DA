package com.tencent.mm.plugin.game.luggage.b;

import android.content.Context;
import com.tencent.luggage.d.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.iw;
import com.tencent.mm.plugin.game.luggage.g.i;
import com.tencent.mm.plugin.webview.luggage.jsapi.br;
import com.tencent.mm.plugin.webview.luggage.jsapi.bs;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONException;
import org.json.JSONObject;

public class aa extends bs<i> {
    @Override // com.tencent.luggage.d.b
    public final String name() {
        return "operateGameCenterMsg";
    }

    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final int dTs() {
        return 1;
    }

    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final void b(b.a aVar) {
    }

    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final void a(Context context, String str, br.a aVar) {
        JSONObject jSONObject;
        AppMethodBeat.i(83084);
        Log.i("MicroMsg.JsApiOperateGameCenterMsg", "invokeInMM");
        try {
            jSONObject = new JSONObject(str);
        } catch (JSONException e2) {
            jSONObject = null;
        }
        if (jSONObject == null) {
            Log.i("MicroMsg.JsApiOperateGameCenterMsg", "data is null");
            aVar.i("invalid_data", null);
            AppMethodBeat.o(83084);
            return;
        }
        int optInt = jSONObject.optInt("cmd");
        JSONObject optJSONObject = jSONObject.optJSONObject("param");
        iw iwVar = new iw();
        iwVar.dNy.EX = optInt;
        iwVar.dNy.param = optJSONObject.toString();
        EventCenter.instance.publish(iwVar);
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("result", Util.nullAsNil(iwVar.dNz.dNA));
        } catch (JSONException e3) {
        }
        aVar.i(null, jSONObject2);
        AppMethodBeat.o(83084);
    }
}

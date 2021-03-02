package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import com.tencent.luggage.d.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.i.a.aj;
import com.tencent.mm.plugin.webview.luggage.g;
import com.tencent.mm.plugin.webview.luggage.jsapi.br;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.sqlitelint.behaviour.persistence.IssueStorage;
import org.json.JSONException;
import org.json.JSONObject;

public class am extends bs<g> {
    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final int dTs() {
        return 2;
    }

    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final void b(b<g>.a aVar) {
    }

    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final void a(Context context, String str, br.a aVar) {
        JSONObject jSONObject;
        AppMethodBeat.i(210948);
        Log.d("MicroMsg.JsApiOpenFinderView", "invokeInMM");
        try {
            jSONObject = new JSONObject(str);
        } catch (Exception e2) {
            jSONObject = null;
        }
        if (jSONObject == null) {
            aVar.i("data is null", null);
            AppMethodBeat.o(210948);
            return;
        }
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put(IssueStorage.COLUMN_EXT_INFO, new JSONObject(jSONObject.optString(IssueStorage.COLUMN_EXT_INFO)));
            ((aj) com.tencent.mm.kernel.g.ah(aj.class)).enterFinderUI(context, jSONObject2.toString());
            aVar.i(null, null);
            AppMethodBeat.o(210948);
        } catch (JSONException e3) {
            aVar.i("fail", null);
            AppMethodBeat.o(210948);
        }
    }

    @Override // com.tencent.luggage.d.b
    public final String name() {
        return "openFinderView";
    }
}

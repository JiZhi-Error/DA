package com.tencent.mm.plugin.game.luggage.b;

import android.content.Context;
import com.tencent.luggage.d.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.api.d;
import com.tencent.mm.plugin.game.luggage.g.i;
import com.tencent.mm.plugin.webview.luggage.jsapi.br;
import com.tencent.mm.plugin.webview.luggage.jsapi.bs;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ac extends bs<i> {
    @Override // com.tencent.luggage.d.b
    public final String name() {
        return "queryHaowanPublish";
    }

    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final int dTs() {
        return 1;
    }

    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final void b(b<i>.a aVar) {
    }

    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final void a(Context context, String str, br.a aVar) {
        JSONArray b2;
        AppMethodBeat.i(83086);
        JSONObject Zc = com.tencent.mm.plugin.webview.luggage.c.b.Zc(str);
        if (Zc == null) {
            b2 = ((d) g.af(d.class)).b(null, true);
        } else {
            JSONArray optJSONArray = Zc.optJSONArray("postIdList");
            if (optJSONArray == null || optJSONArray.length() == 0) {
                b2 = ((d) g.af(d.class)).b(null, true);
            } else {
                b2 = ((d) g.af(d.class)).b(optJSONArray, false);
            }
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("data", b2);
        } catch (JSONException e2) {
        }
        aVar.i(null, jSONObject);
        AppMethodBeat.o(83086);
    }
}

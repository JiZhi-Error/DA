package com.tencent.mm.plugin.game.luggage.b;

import android.content.Context;
import com.tencent.luggage.d.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.api.b;
import com.tencent.mm.plugin.webview.luggage.jsapi.br;
import org.json.JSONException;
import org.json.JSONObject;

public class i extends br {
    @Override // com.tencent.luggage.d.b
    public final String name() {
        return "downloadGameResource";
    }

    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final int dTs() {
        return 2;
    }

    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final void b(b.a aVar) {
    }

    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final void a(Context context, String str, br.a aVar) {
        AppMethodBeat.i(186856);
        try {
            b.a.dSQ().azk(new JSONObject(str).optString("appId", ""));
            aVar.i(null, null);
            AppMethodBeat.o(186856);
        } catch (JSONException e2) {
            aVar.i("fail", null);
            AppMethodBeat.o(186856);
        }
    }
}

package com.tencent.mm.plugin.game.luggage.b;

import android.content.Context;
import com.tencent.luggage.d.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.downloader.model.o;
import com.tencent.mm.plugin.downloader_app.a.a;
import com.tencent.mm.plugin.webview.luggage.jsapi.br;
import org.json.JSONException;
import org.json.JSONObject;

public class b extends br {
    @Override // com.tencent.luggage.d.b
    public final String name() {
        return "addGameDownloadTask";
    }

    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final int dTs() {
        return 2;
    }

    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final void b(b.a aVar) {
    }

    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final void a(Context context, String str, final br.a aVar) {
        AppMethodBeat.i(83052);
        try {
            o.a(context, a.aK(new JSONObject(str)), new o.a() {
                /* class com.tencent.mm.plugin.game.luggage.b.b.AnonymousClass1 */

                @Override // com.tencent.mm.plugin.downloader.model.o.a
                public final void i(String str, JSONObject jSONObject) {
                    AppMethodBeat.i(83051);
                    aVar.i(str, jSONObject);
                    AppMethodBeat.o(83051);
                }
            });
            AppMethodBeat.o(83052);
        } catch (JSONException e2) {
            aVar.i("fail", null);
            AppMethodBeat.o(83052);
        }
    }
}
